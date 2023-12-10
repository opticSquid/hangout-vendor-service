package com.hangout.core.vendorservice.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.hangout.core.vendorservice.entities.food.Hotel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "subcategory", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Hotel.class, name = "hotel")
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class PlatformVendorCommon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String placename;
    private Category category;
    private String subcategory;
    @JsonIgnore
    private UUID ownerid;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId")
    private Address address;
}
