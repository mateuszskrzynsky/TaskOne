package com.example.taksone.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "DEVICE")
public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 128, name = "IDENTIFIER")
    private String identifier;

    @Column(nullable = false, name = "CREATION_DATE")
    private ZonedDateTime creationDate;

    @Column(nullable = true,name = "MODIFICATION_DATE")
    private ZonedDateTime modificationDate;

    @Column(nullable = true,name = "LAUNCH_DATE")
    private ZonedDateTime launchDate;

    @Column(nullable = true, name = "SHUTDOWN_DATE")
    private ZonedDateTime shutdownDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Configuration> configurations = new HashSet<>();
}