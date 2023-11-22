package com.hangout.core.vendorservice.entities.food;

import com.hangout.core.vendorservice.entities.PlatformVendorCommon;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Hotel extends PlatformVendorCommon {
    private Boolean isVegFoodAvailable;

}
