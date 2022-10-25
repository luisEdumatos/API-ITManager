package com.api.itmanager.modules.device.repository;

import com.api.itmanager.modules.device.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    @Query(value = "SELECT * FROM t_device WHERE client_id=?1 AND dtype=?2", nativeQuery = true)
    List<Device> findAllDevicesByTypeAndClientId(Long id, Long dtype);

    @Query(value = "SELECT td.* FROM t_device td JOIN t_employee_device ted " +
                   "ON td.id = ted.device_id " +
                   "WHERE ted.employee_id=?1", nativeQuery = true)
    List<Device> findAllDeviceByEmployeeId(Long employeeId);

}
