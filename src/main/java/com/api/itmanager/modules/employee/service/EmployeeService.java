package com.api.itmanager.modules.employee.service;

import com.api.itmanager.modules.employee.dto.mapper.EmployeeMapper;
import com.api.itmanager.modules.employee.dto.request.EmployeeDTO;
import com.api.itmanager.modules.employee.entity.Employee;
import com.api.itmanager.modules.employee.repository.EmployeeRepository;
import com.api.itmanager.util.exception.EmployeeNotFoundException;
import com.api.itmanager.util.response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public EmployeeDTO findById(Long id) throws EmployeeNotFoundException {
        Employee employee = verifyExists(id);
        return employeeMapper.toDTO(employee);
    }

    public MessageResponseDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employeeToSave = employeeMapper.toModel(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employeeToSave);
        return createMessageResponse(savedEmployee.getId(), "Create employee with ID ");
    }

    public MessageResponseDTO updateByID(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        verifyExists(id);
        employeeDTO.setId(id);
        Employee employeeToUpdate = employeeMapper.toModel(employeeDTO);
        Employee updatedEmployee = employeeRepository.save(employeeToUpdate);
        return createMessageResponse(updatedEmployee.getId(), "Updated employee with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }

    public Employee verifyExists(Long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        return optionalEmployee.get();
    }
}
