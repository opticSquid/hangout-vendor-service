package com.hangout.core.vendorservice.entities;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import com.desoss.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hangout.core.vendorservice.exceptions.GeoJsonParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
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

    // public GeoPoint getGeolocation() {
    // return new GeoPoint(this.geolocation.getX(), this.geolocation.getY());
    // }
    public String getGeolocation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JtsModule());
        return mapper.writeValueAsString(this.geolocation);
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

    @Override
    public String toString() {
        try {
            return "Address [addressId=" + addressId + ", geolocation=" + getGeolocation() + ", buildingNameOrNumber="
                    + buildingNameOrNumber + ", streetName=" + streetName + ", town=" + town + ", state=" + state
                    + ", country=" + country + "]";
        } catch (JsonProcessingException e) {
            throw new GeoJsonParseException("GeoLocation could not be parsed");
        }
    }

}
