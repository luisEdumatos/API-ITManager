package com.api.itmanager.modules.employee.repository;

import com.api.itmanager.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM t_employee WHERE client_id=?1", nativeQuery = true)
    List<Employee> findAllEmployeesByClientId(Long clientId);

    @Query(value = "SELECT te.* FROM t_employee te JOIN t_employee_device ted " +
            "ON te.id = ted.employee_id " +
            "WHERE ted.device_id=?1", nativeQuery = true)
    List<Employee> findAllEmployeeByDeviceId(Long deviceId);
}
