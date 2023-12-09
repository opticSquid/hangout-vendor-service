package com.hangout.core.vendorservice.dtos;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

// ? search radius should be in kms
public record FindPvNearbyRequestBody(Point<G2D> userLocation, Integer searchRadius) {

}
