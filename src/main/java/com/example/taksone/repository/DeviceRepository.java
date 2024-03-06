package com.example.taksone.repository;

import com.example.taksone.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    /**
     * Find a device unique identifer
     *
     * @param deviceId The unique identifier of the device
     * @return An optional containing the found device or empty device found
     */

    Optional<Device> findByIdentifier(String deviceId);
}
