package com.api.itmanager.modules.infrastructure.device.repository;

import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findAllByDtypeAndClientID(Long dtype, Long id);
}
