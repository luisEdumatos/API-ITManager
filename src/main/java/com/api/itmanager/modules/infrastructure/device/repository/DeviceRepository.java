package com.api.itmanager.modules.infrastructure.device.repository;

import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query(value = "SELECT * FROM t_device WHERE client_id=?1 AND dtype=?2", nativeQuery = true)
    List<Device> findAllDevicesByTypeAndClientId(Long id, Long dtype);
}
