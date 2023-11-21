package com.hangout.core.vendorservice.entities;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
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
}
