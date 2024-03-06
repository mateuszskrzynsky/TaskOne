package com.example.taksone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.module.Configuration;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter

public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 128)
    private String deviceId;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = true)
    private LocalDateTime modificationDate;

    @Column(nullable = true)
    private LocalDateTime activationDate;

    @Column(nullable = true)
    private LocalDateTime deactivationDate;

    @Column
    private Address address;


}