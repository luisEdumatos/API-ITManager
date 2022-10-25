package com.api.itmanager.modules.employee_device.repository;

import com.api.itmanager.modules.device.model.Device;
import com.api.itmanager.modules.employee_device.model.EmployeeDevice;
import com.api.itmanager.modules.employee_device.model.EmployeeDeviceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDeviceRepository extends JpaRepository<EmployeeDevice, EmployeeDeviceId> {
}
