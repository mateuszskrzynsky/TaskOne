package com.example.taksone.service;

import com.example.taksone.model.Configuration;
import com.example.taksone.model.Device;
import com.example.taksone.repository.ConfigurationRepository;
import com.example.taksone.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceConfigurationService {
    private final DeviceRepository deviceRepository;
    private final ConfigurationRepository configurationRepository;

    public Optional<Configuration> getConfig(Long id) {
        Optional<Configuration> configurations = configurationRepository.findById(id);
        if(configurations.isEmpty()){
            throw new RuntimeException("Not found");         /* <-- zrobić wyjątek i zamienić  */
        }
        return configurationRepository.findById(id);
    }

    public Optional<Configuration> updateDeviceConfig(Long id, String updateConfig) {
        return configurationRepository.findById(id).map(configuration -> {
            configuration.setConfiguration(updateConfig);
            configuration.setModificationDate(LocalDateTime.now());
            return configurationRepository.save(configuration);
        });
    }
    @Transactional
    public Optional<Configuration> createConfig(Long id, String config) {
        return deviceRepository.findById(id).map(device -> {
            Configuration configuration = new Configuration();
            configuration.setDevice(device);
            configuration.setConfiguration(config);
            configuration.setCreationDate(LocalDateTime.now());
            return configurationRepository.save(configuration);
        });
    }

    public Optional<Configuration> deleteConfig(Long id) {
        Optional<Configuration> configuration = configurationRepository.findById(id);
        configuration.ifPresent(configurationRepository::delete);
        return null;                                // <-- naprawić całe DELETE
    }


}