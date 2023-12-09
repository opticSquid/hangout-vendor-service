package com.hangout.core.vendorservice.dtos;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

public record FindPvNearbyRequestBody(Point<G2D> userLocation, Integer searchRadius) {

}
