package com.hangout.core.vendorservice.services;

import java.util.LinkedList;
import java.util.List;

import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.desoss.jackson.datatype.jts.JtsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hangout.core.vendorservice.dtos.AllPlatformVendors;
import com.hangout.core.vendorservice.dtos.PlatformVendorProjection;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.entities.food.Hotel;
import com.hangout.core.vendorservice.exceptions.GeoJsonParseException;
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

    // public List<PlatformVendorCommon> getAll() {
    // return pvcRepo.findAll();
    // }
    private String getGeolocation(Point location) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JtsModule());
        return mapper.writeValueAsString(location);
    }

    public List<AllPlatformVendors> getAll() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<PlatformVendorProjection> pageOfPlatformVendor = pvcRepo.findAllBroadly(pageable);
        List<PlatformVendorProjection> queryResult = pageOfPlatformVendor.getContent();
        List<AllPlatformVendors> result = new LinkedList<>();
        log.debug("result: {}", queryResult.get(0));
        queryResult.stream().forEach(qr -> {
            try {
                result
                        .add(new AllPlatformVendors(qr.getId().toString(), qr.getPlaceName(), qr.getCategory(),
                                qr.getSubCategory(), getGeolocation(qr.getGeolocation()), qr.getStreetName(),
                                qr.getTown(),
                                qr.getState(), qr.getCountry()));
            } catch (JsonProcessingException e) {
                throw new GeoJsonParseException("GeoJson could not be parsed");
            }
        });
        return result;
    }
}
