package com.hangout.core.vendorservice.dtos;

import com.hangout.core.vendorservice.entities.Category;

import lombok.Builder;

@Builder
public record AllPlatformVendors(String id, String placeName, Category category, String subCategory, String geoLocation,
                String streetName, String town, String state, String country) {

}
