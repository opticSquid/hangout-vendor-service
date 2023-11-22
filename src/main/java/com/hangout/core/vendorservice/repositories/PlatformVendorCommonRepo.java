package com.hangout.core.vendorservice.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hangout.core.vendorservice.entities.PlatformVendorCommon;

public interface PlatformVendorCommonRepo extends JpaRepository<PlatformVendorCommon, UUID> {
    @Query("SELECT p.id, p.placeName, p.category, p.subCategory, a.geolocation, a.streetName, a.town, a.state, a.country "
            +
            "FROM PlatformVendorCommon p " +
            "JOIN p.address a")
    Page<PlatformVendorReflection> findAllBroadly(Pageable pageable);
}
