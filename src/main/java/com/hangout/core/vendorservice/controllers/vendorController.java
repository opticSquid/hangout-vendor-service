package com.hangout.core.vendorservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hangout.core.vendorservice.dtos.AllPlatformVendors;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.services.PlatformServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class vendorController {
    private final PlatformServices pvServices;

    @PostMapping
    public String addVendor(@RequestBody PlatformVendorCommon vendor) {
        return pvServices.addVendor(vendor);
    }

    @GetMapping
    public List<AllPlatformVendors> getAll() {
        return pvServices.getAll();
    }
}
