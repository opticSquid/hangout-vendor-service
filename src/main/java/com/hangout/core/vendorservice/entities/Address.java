package com.hangout.core.vendorservice.entities;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequence;
import org.locationtech.jts.geom.CoordinateSequenceFactory;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.geom.impl.PackedCoordinateSequenceFactory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Entity
@ToString
public class Address {
    @Id
    @GeneratedValue
    private Integer addressId;
    private Point geolocation;
    private String buildingNameOrNumber;
    private String streetName;
    private String town;
    private String state;
    private String country;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Point getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(GeoPoint location) {
        log.debug("location: {}", location);
        double coords[] = { location.getLon(), location.getLat() };
        CoordinateSequenceFactory coordinateSequence = new PackedCoordinateSequenceFactory(
                PackedCoordinateSequenceFactory.DOUBLE);
        coor
        // old
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(location.getLon(), location.getLat());
        this.geolocation = geometryFactory.createPoint(coordinate);
        this.geolocation.setSRID(4326);
    }

    public String getBuildingNameOrNumber() {
        return buildingNameOrNumber;
    }

    public void setBuildingNameOrNumber(String buildingNameOrNumber) {
        this.buildingNameOrNumber = buildingNameOrNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
