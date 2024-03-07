package com.example.taksone.controller;

import com.example.taksone.dto.ConfigurationReadDto;
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
import org.springframework.context.annotation.PropertySources;
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

    /**
     * Retrive a configuratuon by it's ID
     * @param id The ID of the configuration to retrive
     * @return The requested configuration if found, with HTTP status 200
     */
    @Operation(summary = "Get Configuration", description = "Retrives a configuration by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<ConfigurationReadDto> getConfiguration(@PathVariable Long id){
        ConfigurationReadDto configuration = configurationService.getConfigurationById(id);
        return ResponseEntity.ok(configuration);
    }

    /**
     * Updates an existing configuration with new data
     * @param id The ID of the configuration to update
     * @param request Data required for updating the configuration
     * @return The updated configuration with HTTP status 200
     */

    @Operation(summary = "updated Configuration", description = "Updates an existing configuration with new data")
    @PutMapping("/{id}")
    public ResponseEntity<Configuration> updateConfiguration (@PathVariable Long id,@Valid @RequestBody ConfigurationReqDto request){
        Configuration updateConfiguration = configurationService.updateConfiguration(id,request.getConfiguration());
        return ResponseEntity.ok(updateConfiguration);
    }

    /**
     * Delete a configuration by its ID
     * @param id The ID of the configuration to delete
     * @return HTTP status 204 with no content it the deletion was successful
     */
    @Operation(summary = "Delete Configuration", description = "Deletes a configuration by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id){
        configurationService.deleteConfiguration(id);
        return ResponseEntity.noContent().build();
    }

}
