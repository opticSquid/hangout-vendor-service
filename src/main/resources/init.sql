-- Adding a QuadTree GiST index on the geometry colum for faster search
CREATE INDEX CONCURRENTLY locationIndex ON address USING GIST (geolocation);
-- Forcing postgres to update information about added index on geolocation to use in further queries
VACUUM ANALYZE address (geolocation);