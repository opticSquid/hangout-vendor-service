package com.hangout.core.vendorservice.controllers;

import com.hangout.core.vendorservice.dtos.FindPvNearbyRepresentation;
import com.hangout.core.vendorservice.dtos.FindPvNearbyRequestBody;
import com.hangout.core.vendorservice.dtos.PlatformVendorRepresentation;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.services.PlatformServices;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class vendorController {
    private final PlatformServices pvServices;

    @PostMapping
    public String addVendor(@RequestBody PlatformVendorCommon vendor) {
        return pvServices.addVendor(vendor);
    }

    @Observed(name = "find pvs", contextualName = "getAll Controller ==> getAllPaged Service", lowCardinalityKeyValues = {"pageNumber", "1"})
    @GetMapping
    public List<PlatformVendorRepresentation> getAll(@RequestParam Integer pageNumber) {
        return pvServices.getAllPaged(pageNumber);
    }

    @GetMapping("/search")
    public List<FindPvNearbyRepresentation> findNearby(@RequestBody FindPvNearbyRequestBody searchDetails, @RequestParam Integer pageNumber) {
        return pvServices.getAllNearby(searchDetails, pageNumber);
    }
    // @GetMapping("/batch")
    // public ResponseEntity<String> batchInsert() {
    // if (pvServices.pushBatchInsert()) {
    // return new ResponseEntity<String>("batch insert done", HttpStatus.OK);
    // } else {
    // return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }
}
