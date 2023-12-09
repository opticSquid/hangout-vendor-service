-- create database if not exists vendors;
-- CREATE EXTENSION fuzzystrmatch;
-- CREATE EXTENSION postgis;
-- CREATE EXTENSION postgis_tiger_geocoder;
-- CREATE EXTENSION postgis_topology;
-- Adding a QuadTree GiST index on the geometry colum for faster search
CREATE INDEX CONCURRENTLY locationIndex ON address USING GIST (geolocation);
-- Forcing postgres to update information about added index on geolocation to use in further queries
VACUUM ANALYZE address (geolocation);
-- Creating a stored procedure to fetch nearby pvs
CREATE OR REPLACE FUNCTION find_all_nearby(
  _lon double precision,
  _lat double precision,
  _radius integer,
  _pageNumber integer
)
RETURNS TABLE (
  id uuid,
  placeName varchar(255),
  category smallint,
  subCategory varchar(255),
  geolocation geometry(Point, 4326),
  streetName varchar(255),
  town varchar(255),
  state varchar(255),
  country varchar(255),
  distance double precision
) AS $$
BEGIN
  RETURN QUERY
  SELECT
    P.ID,
    P.PLACENAME,
    P.CATEGORY,
    P.SUBCATEGORY,
    A.GEOLOCATION,
    A.STREETNAME,
    A.TOWN,
    A.STATE,
    A.COUNTRY,
    ST_Distance(A.geolocation::geography, ST_GeomFromText('POINT(' || _lon || ' ' || _lat || ')', 4326)::geography, false) / 1000.00 AS DISTANCE
  FROM PLATFORM_VENDOR_COMMON P
  JOIN ADDRESS A ON P.ADDRESS_ID = A.ADDRESS_ID
  WHERE ST_DWithin(A.geolocation::geography, ST_GeomFromText('POINT(' || _lon || ' ' || _lat || ')', 4326)::geography, _radius*1000, false)
  ORDER BY A.geolocation::geography <-> ST_GeomFromText('POINT(' || _lon || ' ' || _lat || ')', 4326)::geography
  OFFSET _pageNumber
  LIMIT 20;
END;
$$ LANGUAGE plpgsql;