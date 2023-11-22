package com.hangout.core.vendorservice.entities;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.ToString;

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

    public GeoPoint getGeolocation() {
        return new GeoPoint(this.geolocation.getX(), this.geolocation.getY());
    }

    public void setGeolocation(GeoPoint location) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        Coordinate coordinate = new Coordinate(location.getLon(), location.getLat());
        this.geolocation = geometryFactory.createPoint(coordinate);
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
