package com.example.taksone.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "CONFIGURATION")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 128, name = "IDENTIFIER")
    private String identifier;

    @ManyToOne(fetch = FetchType.EAGER) //TODO ?
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(nullable = false, name = "CONFIGURATION", columnDefinition = "TEXT", length = 10_000)
    private String configuration;

    @Column(nullable = false, name = "CREATION_DATE")
    private ZonedDateTime creationDate;

    @Column(nullable = false, name = "MODIFICATION_DATE")
    private ZonedDateTime modificationDate;

}