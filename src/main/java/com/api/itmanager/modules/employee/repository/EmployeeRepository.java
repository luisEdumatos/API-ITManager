package com.api.itmanager.modules.employee.repository;

import com.api.itmanager.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM t_employee WHERE client_id=?1", nativeQuery = true)
    List<Employee> findAllEmployeesByClientId(Long clientId);
}
