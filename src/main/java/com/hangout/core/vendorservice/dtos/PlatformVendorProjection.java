package com.hangout.core.vendorservice.dtos;

import java.util.UUID;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

public interface PlatformVendorProjection {
    UUID getId();

    String getPlacename();

    Integer getCategory();

    String getSubcategory();

    Point<G2D> getGeolocation();

    String getStreetname();

    String getTown();

    String getState();

    String getCountry();

    // only used when finding nearby pvs
    Double getDistance();
}
