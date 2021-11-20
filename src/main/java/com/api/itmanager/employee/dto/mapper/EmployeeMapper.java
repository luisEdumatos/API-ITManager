package com.api.itmanager.employee.dto.mapper;

import com.api.itmanager.employee.dto.request.EmployeeDTO;
import com.api.itmanager.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toModel(EmployeeDTO employeeDTO);

    EmployeeDTO toDTO(Employee employee);
}
