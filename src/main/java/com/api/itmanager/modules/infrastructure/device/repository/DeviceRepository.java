package com.api.itmanager.modules.infrastructure.device.repository;

import com.api.itmanager.modules.infrastructure.device.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
