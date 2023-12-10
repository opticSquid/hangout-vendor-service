package com.hangout.core.vendorservice.dtos;

import java.util.UUID;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import lombok.Getter;

@Getter
public class FindPvNearbyRepresentation extends PlatformVendorRepresentation {
    private Double distance;

    public FindPvNearbyRepresentation(UUID id, String placeName, Integer category, String subCategory,
            Point<G2D> geolocation, String streetName, String town, String state, String country, Double distance) {
        super(id, placeName, category, subCategory, geolocation, streetName, town, state, country);
        this.distance = distance;
    }

}
