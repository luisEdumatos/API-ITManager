package com.api.itmanager.modules.employee.repository;

import com.api.itmanager.modules.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameIgnoreCaseContaining(String name);

    List<Employee> findByClientId(Long id);

    Boolean existsByClientId(Long id);

}
