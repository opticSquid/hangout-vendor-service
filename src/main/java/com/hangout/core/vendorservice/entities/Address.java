package com.hangout.core.vendorservice.entities;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

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
    private final Point<G2D> geolocation;
    private final String buildingnameornumber;
    private final String streetname;
    private final String town;
    private final String state;
    private final String country;
}