package com.hangout.core.vendorservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hangout.core.vendorservice.dtos.FindPvNearbyProjection;
import com.hangout.core.vendorservice.dtos.PlatformVendorProjection;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;

public interface PlatformVendorCommonRepo extends JpaRepository<PlatformVendorCommon, UUID> {
    @Query(value = "SELECT P.ID, P.PLACENAME, P.CATEGORY, P.SUBCATEGORY, A.GEOLOCATION, A.STREETNAME, A.TOWN, A.STATE, A.COUNTRY FROM PLATFORM_VENDOR_COMMON P JOIN ADDRESS A ON P.ADDRESS_ID = A.ADDRESS_ID OFFSET :pageNumber LIMIT 20", nativeQuery = true)
    List<PlatformVendorProjection> findAllPaged(@Param("pageNumber") Integer pageNumber);

    // ST_Distance, ST_DWithin are passed with a false param to stop going to
    // unnessecery extra precison. It takes more time
    // Distances are calculate using geodesics not cartesian coordinates
    @Query(value = "SELECT * from find_all_nearby(:lon\\:\\:double precision, :lat\\:\\:double precision, :radius, :pageNumber)", nativeQuery = true)
    List<FindPvNearbyProjection> findAllNearby(@Param("lon") Double lon, @Param("lat") Double lat,
            @Param("radius") Integer radius, @Param("pageNumber") Integer pageNumber);
}
