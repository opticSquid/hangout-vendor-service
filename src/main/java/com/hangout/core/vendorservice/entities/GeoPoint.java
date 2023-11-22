package com.hangout.core.vendorservice.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class GeoPoint {
    private final String type;
    private Double lon;
    private Double lat;

    public GeoPoint() {
        type = "Point";
    }

    public GeoPoint(Double lon, Double lat) {
        this.type = "Point";
        this.lon = lon;
        this.lat = lat;
        log.debug("lon: {}, lat: {}", lon, lat);
    }
}
