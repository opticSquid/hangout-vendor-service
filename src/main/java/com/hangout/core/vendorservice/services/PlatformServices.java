package com.hangout.core.vendorservice.services;

// import static org.geolatte.geom.builder.DSL.g;
// import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hangout.core.vendorservice.dtos.PlatformVendorProjection;
import com.hangout.core.vendorservice.dtos.PlatformVendorReprs;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;
import com.hangout.core.vendorservice.entities.food.Hotel;
import com.hangout.core.vendorservice.repositories.HotelRepo;
import com.hangout.core.vendorservice.repositories.PlatformVendorCommonRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlatformServices {
    private final PlatformVendorCommonRepo pvcRepo;
    private final HotelRepo hotelRepo;

    public String addVendor(PlatformVendorCommon vendor) {
        Hotel tobeSaved = (Hotel) vendor;
        if (vendor instanceof Hotel) {
            Hotel saved = hotelRepo.save(tobeSaved);
            return saved.getId().toString();
        } else {
            return null;
        }
    }

    public List<PlatformVendorReprs> getAllPaged(Integer pageNumber) {
        // If the incoming value of pageNumber is less than or equal to 0, then it is
        // considered as page 1
        pageNumber = pageNumber <= 0 ? 1 : pageNumber;
        Integer offSet = (pageNumber - 1) * 20 + 1;
        List<PlatformVendorProjection> model = pvcRepo.findAllPaged(offSet);
        return model.stream().map(m -> new PlatformVendorReprs(m.getId(), m.getPlacename(), m.getCategory(),
                m.getSubcategory(), m.getGeolocation(), m.getStreetname(), m.getTown(), m.getState(), m.getCountry()))
                .toList();
    }

    // ! keeping this for future reference
    // public Boolean pushBatchInsert() {
    // List<Hotel> sampleHotels = IntStream.range(1, 50001).parallel().mapToObj(i ->
    // createHotel(i))
    // .collect(Collectors.toList());
    // Integer batchSize = 1000;
    // try {
    // IntStream.range(0, sampleHotels.size() / batchSize + 1)
    // .parallel()
    // .forEach(i -> {
    // int startIdx = i * batchSize;
    // int endIdx = Math.min((i + 1) * batchSize, sampleHotels.size());
    // List<Hotel> batch = sampleHotels.subList(startIdx, endIdx);
    // if (!batch.isEmpty()) {
    // hotelRepo.saveAll(batch);
    // }
    // });

    // return true;
    // } catch (Exception ex) {
    // return false;
    // }
    // }

    // private Hotel createHotel(int i) {
    // Hotel hotel = new Hotel();
    // hotel.setIsVegFoodAvailable(true);
    // hotel.setPlacename("hotel" + i);
    // hotel.setCategory(Category.FOOD);
    // hotel.setSubcategory("hotel");
    // hotel.setOwnerid(UUID.randomUUID());
    // Address address = new Address();
    // address.setGeolocation(generateRandomGeoLocation());
    // address.setBuildingnameornumber("building" + i);
    // address.setStreetname("street" + i);
    // address.setTown("town" + i);
    // address.setState("state" + i);
    // address.setCountry("country" + i);
    // hotel.setAddress(address);
    // return hotel;
    // }

    // public Point<G2D> generateRandomGeoLocation() {
    // // Generate random values for lon (-180 to 180) and lat (-90 to 90)
    // double lon = Math.random() * 359 - 180;
    // double lat = Math.random() * 180 - 90;
    // // Create and return a GeoLocation object using the constructor
    // return new Point<G2D>(g(lon, lat), WGS84);
    // }
}
