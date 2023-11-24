package com.hangout.core.vendorservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hangout.core.vendorservice.dtos.PlatformVendorProjection;
import com.hangout.core.vendorservice.dtos.PlatformVendorReprs;
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

    // public List<PlatformVendorCommon> getAll() {
    // return pvcRepo.findAll();
    // }
    // private String getGeolocation(Point location) throws JsonProcessingException
    // {
    // ObjectMapper mapper = new ObjectMapper();
    // mapper.registerModule(new JtsModule());
    // return mapper.writeValueAsString(location);
    // }

    // public List<AllPlatformVendors> getAllPaged() {
    // Pageable pageable = PageRequest.of(0, 20);
    // Page<PlatformVendorProjection> pageOfPlatformVendor =
    // pvcRepo.findAllBroadly(pageable);
    // List<PlatformVendorProjection> queryResult =
    // pageOfPlatformVendor.getContent();
    // List<AllPlatformVendors> result = new LinkedList<>();
    // log.debug("result: {}", queryResult.get(0));
    // queryResult.stream().forEach(qr -> {
    // result
    // .add(new AllPlatformVendors("", qr.getPlaceName(),
    // Category.getByValue(qr.getCategory()),
    // qr.getSubCategory(), qr.getGeolocation(), qr.getStreetName(),
    // qr.getTown(),
    // qr.getState(), qr.getCountry()));
    // });
    // return result;
    // }

    public List<PlatformVendorReprs> getAllNonPaged() {
        List<PlatformVendorProjection> model = pvcRepo.findAllNonPaged();
        return model.stream().map(m -> new PlatformVendorReprs(m.getId(), m.getPlacename(), m.getCategory(),
                m.getSubcategory(), m.getGeolocation(), m.getStreetname(), m.getTown(), m.getState(), m.getCountry()))
                .toList();
    }
}
