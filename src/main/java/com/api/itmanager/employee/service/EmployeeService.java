package com.api.itmanager.employee.service;

import com.api.itmanager.employee.dto.mapper.EmployeeMapper;
import com.api.itmanager.employee.dto.request.EmployeeDTO;
import com.api.itmanager.employee.entity.Employee;
import com.api.itmanager.employee.repository.EmployeeRepository;
import com.api.itmanager.util.response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    public List<EmployeeDTO> listAll() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .map(employeeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employeeToSave = employeeMapper.toModel(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return createMessageResponse(savedEmployee.getId(), "Create employee with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }

}
