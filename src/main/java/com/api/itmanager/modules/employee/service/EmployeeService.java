package com.api.itmanager.modules.employee.service;

import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee.dto.EmployeeResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.repository.EmployeeRepository;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.exception.EmployeeNotFoundException;
import com.api.itmanager.util.response.Response;
import com.api.itmanager.util.validation.EmployeeValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ClientService clientService;

    public List<EmployeeResponse> listAll() {
        return new ArrayList<>();
//        return employeeRepository
//                .findAll()
//                .stream()
//                .map(EmployeeResponse::of)
//                .toList();
    }

    public EmployeeResponse findById(Long id) throws EmployeeNotFoundException {
        return employeeRepository
                .findById(id)
                .map(EmployeeResponse::of)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Response createEmployee(EmployeeRequest request) throws ClientNotFoundException {
        EmployeeValidation.employeeCreateOrUpdateValidation(request);

        var client = clientService.findById(request.getClientId());

        var employee = employeeRepository.save(Employee.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created employee with ID " + employee.getId());
    }

    public Response updateByID(Long id, EmployeeRequest request) throws EmployeeNotFoundException, ClientNotFoundException {
        findById(id);

        EmployeeValidation.employeeCreateOrUpdateValidation(request);

        employeeRepository.save(createEmployeeToUpdate(id, request));

        return new Response(HttpStatus.OK.value(), "Updated employee with ID " + id);
    }

    private Employee createEmployeeToUpdate(Long id, EmployeeRequest request) throws ClientNotFoundException {
        var client = clientService.findById(request.getClientId());

        var employeeToUpdate = Employee.of(request, client);
        employeeToUpdate.setId(id);

        return  employeeToUpdate;
    }

    public Response delete(Long id) throws EmployeeNotFoundException {
        findById(id);
        employeeRepository.deleteById(id);

        return new Response(HttpStatus.OK.value(), "Deleted employee with ID " + id);
    }
}