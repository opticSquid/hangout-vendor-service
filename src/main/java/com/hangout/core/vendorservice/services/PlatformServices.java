package com.hangout.core.vendorservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.entities.food.Hotel;
import com.hangout.core.vendorservice.repositories.HotelRepo;
import com.hangout.core.vendorservice.repositories.PlatformVendorCommonRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlatformServices {
    private final PlatformVendorCommonRepo pvcRepo;
    private final HotelRepo hotelRepo;

    public String addVendor(PlatformVendorCommon vendor) {
        Hotel tobeSaved = (Hotel) vendor;
        log.debug("entity: {}", vendor.getAddress());
        if (vendor instanceof Hotel) {
            Hotel saved = hotelRepo.save(tobeSaved);
            return saved.getId().toString();
        } else {
            return null;
        }
    }

    public List<PlatformVendorCommon> getAll() {
        return pvcRepo.findAll();
    }
}
