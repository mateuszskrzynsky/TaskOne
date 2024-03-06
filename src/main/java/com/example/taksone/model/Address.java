package com.example.taksone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = true)
    private String name;

    @Column(length = 128, nullable = false)
    private String street;

    @Column(name = "building_number", length = 128, nullable = false)
    private String buildingNumber;

    @Column(name = "apartment_number", length = 128, nullable = true)
    private String apartmentNumber;

    @Column(length = 128, nullable = false)
    private String city;

    @Column(name = "post_code", length = 128, nullable = false)
    private String postCode;

    @Column(length = 128, nullable = false)
    private String country;




}
