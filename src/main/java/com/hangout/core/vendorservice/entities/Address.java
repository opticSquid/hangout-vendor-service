package com.hangout.core.vendorservice.entities;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Integer addressId;
    private Point<G2D> geolocation;
    private String buildingnameornumber;
    private String streetname;
    private String town;
    private String state;
    private String country;
}