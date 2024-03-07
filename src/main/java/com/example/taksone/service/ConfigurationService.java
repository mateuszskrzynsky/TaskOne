package com.example.taksone.service;

import com.example.taksone.dto.ConfigurationReadDto;
import com.example.taksone.model.Configuration;
import com.example.taksone.model.Device;
import com.example.taksone.repository.ConfigurationRepository;
import com.example.taksone.repository.DeviceRepository;
import com.example.taksone.utils.mapper.ConfigurationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;
    private final DeviceService deviceService;
    private final ConfigurationMapper configurationMapper;

    /**
     * Creates a configuration for a device
     * @param deviceId The ifnetife od the device fot which the configuration is created
     * @param configurationJson The configuration
     * @return
     */
    public Configuration createConfiguration(String deviceId, String configurationJson) {
        Device device = deviceService.findOrCreateDevice(deviceId);
        Configuration configuration = buildConfiguration(deviceId, device, configurationJson);
        return configurationRepository.save(configuration);
    }


    /**
     * Builds a new Configuration object with the provided details
     * @param deviceId The identifier of the device for which the congfiguration is being created
     * @param device The Device object carresponding to the provided deviceId
     * @param configurationJson The configuration details in JSON format
     * @return A new Configuration object populated with the provided details
     */
    private Configuration buildConfiguration(String deviceId, Device device, String configurationJson) {
        Configuration configuration = new Configuration();
        configuration.setIdentifier(deviceId);
        configuration.setDevice(device);
        configuration.setConfiguration(configurationJson);
        return configuration;
    }


    /**
     * Retrives a configuration by its unique identifier and converts it to a DTO
     * @param id The unique identifier of the configuration to retrieve
     * @return The ConfigurationReadDto corresponding to the requested configuration
     * @throws EntityNotFoundException if no configuration id found with the provided id
     */

    public ConfigurationReadDto getConfigurationById(Long id) {
        return configurationRepository.findById(id)
                .map(configurationMapper::toDto)
                .orElseThrow(()->new EntityNotFoundException("Configuration not found"));


    }


    /**
     * Updates an existing configuration with new details
     * @param id The unique identifier of the configuration to update
     * @param configurationJSON The new configuration details in JSON format
     * @return The update Configuration object
     * @throws EntityNotFoundException if no configuration is found with provided id
     */

    public Configuration updateConfiguration(Long id, String configurationJSON) {
        Configuration configuration = configurationRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Configuration not found"));
        configuration.setConfiguration(configurationJSON);
        return configurationRepository.save(configuration);

    }

    /**
     * Deletes a configuration by its unique identifier
     *
     * @param id The unique identifier of the configuration to delete
     * @throws EntityNotFoundException if no configuration is found with provided id
     */

    public void deleteConfiguration(Long id) {
        if (configurationRepository.existsById(id)){
            throw new EntityNotFoundException("Configuration not found");
        }
        configurationRepository.deleteById(id);
    }
}