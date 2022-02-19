package com.api.itmanager.modules.employee.repository;

import com.api.itmanager.modules.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
