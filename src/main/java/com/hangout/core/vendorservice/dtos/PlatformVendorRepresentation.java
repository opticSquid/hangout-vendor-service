package com.hangout.core.vendorservice.dtos;

import java.io.Serializable;
import java.util.UUID;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import com.hangout.core.vendorservice.entities.Category;

import lombok.Getter;

@Getter
public class PlatformVendorRepresentation implements Serializable {
    private UUID id;
    private String placeName;
    private Category category;
    private String subCategory;
    private Point<G2D> geolocation;
    private String streetName;
    private String town;
    private String state;
    private String country;

    public PlatformVendorRepresentation(UUID id, String placeName, Integer category, String subCategory,
            Point<G2D> geolocation, String streetName,
            String town, String state, String country) {
        this.id = id;
        this.placeName = placeName;
        this.category = Category.getByValue(category);
        this.subCategory = subCategory;
        this.geolocation = geolocation;
        this.streetName = streetName;
        this.town = town;
        this.state = state;
        this.country = country;
    }
}
