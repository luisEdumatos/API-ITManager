package com.api.itmanager.modules.employee.service;

import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee.dto.EmployeeResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.repository.EmployeeRepository;
import com.api.itmanager.util.exception.EmployeeNotFoundException;
import com.api.itmanager.util.response.Response;
import com.api.itmanager.util.validation.EmployeeValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ClientService clientService;

    public EmployeeResponse findById(Long id) {
        return employeeRepository
                .findById(id)
                .map(EmployeeResponse::of)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

    public Response createEmployee(EmployeeRequest request) {
        EmployeeValidation.employeeCreateOrUpdateValidation(request);

        var client = clientService.findById(request.getClientId());

        var employee = employeeRepository.save(Employee.of(request, client));

        return new Response("Created employee with ID " + employee.getId());
    }

    public Response updateByID(Long id, EmployeeRequest request) {
        findById(id);

        EmployeeValidation.employeeCreateOrUpdateValidation(request);

        employeeRepository.save(createEmployeeToUpdate(id, request));

        return new Response("Updated employee with ID " + id);
    }

    private Employee createEmployeeToUpdate(Long id, EmployeeRequest request) {
        var client = clientService.findById(request.getClientId());

        var employeeToUpdate = Employee.of(request, client);
        employeeToUpdate.setId(id);

        return  employeeToUpdate;
    }

    public Response delete(Long id) {
        findById(id);
        employeeRepository.deleteById(id);

        return new Response("Deleted employee with ID " + id);
    }
}