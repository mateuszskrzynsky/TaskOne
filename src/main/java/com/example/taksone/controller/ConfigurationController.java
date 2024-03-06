package com.example.taksone.controller;

import com.example.taksone.model.Configuration;
import com.example.taksone.model.Device;
import com.example.taksone.repository.ConfigurationRepository;
import com.example.taksone.repository.DeviceRepository;
import com.example.taksone.service.ConfigurationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/configurations")
@RequiredArgsConstructor
@Tag(name = "Configuration Controller",description = "Endpoints for mapping configurations")
public class ConfigurationController {
    private final ConfigurationService service;
    private final DeviceRepository deviceRepository;
    private final ConfigurationRepository configurationRepository;

    @GetMapping("/get")
    public ResponseEntity<List> getById(@RequestParam Long id){
        List<Configuration> devices =
    }

    @PutMapping("/update")
    public ResponseEntity<Configuration> updateConfiguration(@PathVariable Long id, @RequestBody String config) {
        Optional<Configuration> updatedConfiguration = service.updateDeviceConfig(id, config);
        return updatedConfiguration
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Configuration> createConfiguration(@RequestParam Long id, @RequestBody String config) {
        Optional<Configuration> createdConfiguration = service.createConfig(id, config);
        return createdConfiguration
                .map(configuration -> new ResponseEntity<>(configuration, HttpStatus.CREATED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete")
    public void deleteDevice(Long id){
        Device deleteDevice = DeviceRepository
    }

    //DELETE
}