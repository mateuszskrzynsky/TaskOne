package com.example.taksone.service;

import com.example.taksone.model.Configuration;
import com.example.taksone.model.Device;
import com.example.taksone.repository.ConfigurationRepository;
import com.example.taksone.repository.DeviceRepository;
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
}