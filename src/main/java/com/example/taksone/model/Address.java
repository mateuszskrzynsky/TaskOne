package com.example.taksone.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = true, name = "NAME")
    private String name;

    @Column(length = 128, nullable = false, name = "STREET")
    private String street;

    @Column(name = "BUILDING_NUMBER", length = 128, nullable = false)
    private String buildingNumber;

    @Column(name = "APARTMENT_NUMBER", length = 128, nullable = true)
    private String apartmentNumber;

    @Column(length = 128, nullable = false, name = "CITY")
    private String city;

    @Column(name = "POST_CODE", length = 128, nullable = false)
    private String postCode;

    @Column(length = 128, nullable = false, name = "COUNTYR")
    private String country;




}
