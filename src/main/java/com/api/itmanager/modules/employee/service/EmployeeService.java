package com.api.itmanager.modules.employee.service;

import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee.dto.EmployeeResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.repository.EmployeeRepository;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.exception.EmployeeNotFoundException;
import com.api.itmanager.util.response.SuccessResponse;
import com.api.itmanager.util.exception.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ClientService clientService;

    public List<EmployeeResponse> listAll() {
        return employeeRepository
                .findAll()
                .stream()
                .map(EmployeeResponse::of)
                .collect(Collectors.toList());
    }

    public EmployeeResponse findById(Long id) throws EmployeeNotFoundException {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return EmployeeResponse.of(employee);
    }

    public SuccessResponse createEmployee(EmployeeRequest request) throws ClientNotFoundException {
        validateEmployeeDataInformed(request);
        validateClientInformed(request);
        var client = clientService.findById(request.getClientId());
        var employee = employeeRepository.save(Employee.of(request, client));

        return new SuccessResponse(HttpStatus.CREATED.value(), "Created employee with ID " + employee.getId());
    }

    public SuccessResponse updateByID(Long id, EmployeeRequest request) throws EmployeeNotFoundException, ClientNotFoundException {
        validateEmployeeDataInformed(request);
        validateClientInformed(request);
        verifyExists(id);
        var client = clientService.findById(request.getClientId());
        var employeeToUpdate = Employee.of(request, client);
        employeeToUpdate.setId(id);
        employeeRepository.save(employeeToUpdate);

        return new SuccessResponse(HttpStatus.OK.value(), "Updated employee with ID " + employeeToUpdate.getId());
    }

    private void validateEmployeeDataInformed(EmployeeRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The employee's name was not informed.");
        }

        if (isEmpty(request.getAdmissionDate())) {
            throw new ValidationException("The employee's admission date was not informed.");
        }
    }

    private void validateClientInformed(EmployeeRequest request) {
        if (isEmpty(request.getClientId())) {
            throw new ValidationException("The client ID was not informed.");
        }
    }

    public SuccessResponse delete(Long id) throws EmployeeNotFoundException {
        verifyExists(id);
        employeeRepository.deleteById(id);
        return new SuccessResponse(HttpStatus.OK.value(), "Deleted employee with ID " + id);
    }

    public Employee verifyExists(Long id) throws EmployeeNotFoundException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException(id);
        }
        return optionalEmployee.get();
    }
}
