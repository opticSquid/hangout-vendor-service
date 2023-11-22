package com.hangout.core.vendorservice.dtos;

import java.util.UUID;

import org.locationtech.jts.geom.Point;

import com.hangout.core.vendorservice.entities.Category;

public interface PlatformVendorProjection {
    UUID getId();

    String getPlaceName();

    Category getCategory();

    String getSubCategory();

    Point getGeolocation();

    String getStreetName();

    String getTown();

    String getState();

    String getCountry();

}
