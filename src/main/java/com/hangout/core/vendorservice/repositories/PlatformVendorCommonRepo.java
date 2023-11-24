package com.hangout.core.vendorservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hangout.core.vendorservice.dtos.PlatformVendorProjection;
import com.hangout.core.vendorservice.entities.PlatformVendorCommon;

public interface PlatformVendorCommonRepo extends JpaRepository<PlatformVendorCommon, UUID> {
    // @Query("SELECT p.id, p.placeName, p.category, p.subCategory, a.geolocation,
    // a.streetName, a.town, a.state, a.country "
    // +
    // "FROM PlatformVendorCommon p " +
    // "JOIN p.address a")
    // Page<PlatformVendorProjection> findAllBroadly(Pageable pageable);

    // @Query("SELECT p.id, p.placeName, p.category, p.subCategory, a.geolocation,
    // a.streetName, a.town, a.state, a.country "
    // +
    // "FROM PlatformVendorCommon p " +
    // "JOIN p.address a")
    @Query(value = "SELECT P.ID, P.PLACENAME, P.CATEGORY, P.SUBCATEGORY, A.GEOLOCATION, A.STREETNAME, A.TOWN, A.STATE, A.COUNTRY FROM PLATFORM_VENDOR_COMMON P JOIN ADDRESS A ON P.ADDRESS_ID = A.ADDRESS_ID", nativeQuery = true)
    List<PlatformVendorProjection> findAllNonPaged();
}
