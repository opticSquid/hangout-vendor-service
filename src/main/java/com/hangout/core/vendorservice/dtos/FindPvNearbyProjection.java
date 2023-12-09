package com.hangout.core.vendorservice.dtos;

public interface FindPvNearbyProjection extends PlatformVendorProjection {

    // only used when finding nearby pvs
    Double getDistance();
}
