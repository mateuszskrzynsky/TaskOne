package com.example.taksone.service;

import com.example.taksone.model.Device;
import com.example.taksone.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    /**
     * find an existing device by its identifier ao creates a new one if does not exist
     *
     * @parem deviceId the unique identifie ad the device
     * @return The found
     */
    public Device findOrCreateDevice(String deviceId) {
        return deviceRepository.findByIdentifier(deviceId)
                .orElseGet(() -> createNewDevice(deviceId));
    }

    /**
     * Creates a new device entity with the given identifer
     * @param deviceId The unique identifier for the new device
     * @return The newly created Device object
     */
    private Device createNewDevice(String deviceId) {
        Device newDevice = new Device();
        newDevice.setIdentifier(deviceId);
        return deviceRepository.save(newDevice);
    }
}
