package com.example.taksone.controller;

import com.example.taksone.dto.ConfigurationReqDto;
import com.example.taksone.model.Configuration;
import com.example.taksone.model.Device;
import com.example.taksone.repository.ConfigurationRepository;
import com.example.taksone.repository.DeviceRepository;
import com.example.taksone.service.ConfigurationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    private final ConfigurationService configurationService;

    /**
     * Creates a new devices configuration based on the provided data.
     *
     * @parm request Data required to create the configuration
     * @return The created configuration with HTTP status 201
     */
    @Operation(summary = "Create configuration", description = "Creates a new device configuration provided data")
    @PostMapping
    public ResponseEntity<Configuration>createConfiguration(@Valid @RequestBody ConfigurationReqDto request){
        Configuration configuration = configurationService.createConfiguration(request.getIdentifier(),request.getConfiguration());
        return new ResponseEntity<>(configuration,HttpStatus.CREATED);
    }


}
