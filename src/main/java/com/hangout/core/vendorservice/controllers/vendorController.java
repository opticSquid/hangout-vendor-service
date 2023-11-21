package com.hangout.core.vendorservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.services.PlatformServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class vendorController {
    private final PlatformServices pvServices;

    @PostMapping
    public String addVendor(PlatformVendorCommon vendor) {
        return pvServices.addVendor(vendor);
    }
}
