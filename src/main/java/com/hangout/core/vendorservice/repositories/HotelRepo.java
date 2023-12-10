package com.hangout.core.vendorservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hangout.core.vendorservice.entities.food.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, UUID> {

}
