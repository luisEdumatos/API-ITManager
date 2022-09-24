package com.api.itmanager;

import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee.dto.EmployeeResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.repository.EmployeeRepository;
import com.api.itmanager.modules.employee.service.EmployeeService;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.exception.EmployeeNotFoundException;
import com.api.itmanager.util.exception.ValidationException;
import com.api.itmanager.util.response.Response;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@RunWith(SpringRunner.class)
public class EmployeeServiceTest extends ApiItmanagerApplicationTests {
/*
    private Faker clientFaker;

    private Faker employeeFaker;

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private ClientRepository clientRepository;

    @Before
    public void setup() {
        this.employeeFaker = new Faker(new Locale("pt-BR"));
        this.clientFaker = new Faker(new Locale("pt-BR"));

        Employee employee1 = createEmployeeFaker(1L);
        employee1.setAdmissionDate("01/03/2022");

        Employee employee2 = createEmployeeFaker(2L);

        Employee employee3 = createEmployeeFaker(3L);

        Client client1 = createClientFaker();

        Mockito.when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee1, employee2, employee3));
        Mockito.when(employeeRepository.findById(employee1.getId())).thenReturn(Optional.of(employee1));
        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee1);
        Mockito.when(clientRepository.findById(client1.getId())).thenReturn(Optional.of(client1));
    }

    private Client createClientFaker() {
        return Client.builder()
                .id(1L)
                .name(clientFaker.company().name())
                .address(clientFaker.address().fullAddress())
                .cnpj(clientFaker.numerify("##############"))
                .build();
    }

    private Employee createEmployeeFaker(Long id) {
        return Employee.builder()
                .id(id)
                .client(createClientFaker())
                .name(employeeFaker.name().name())
                .admissionDate(employeeFaker.numerify("##/##/####"))
                .build();
    }

    @Test
    public void testListAllEmployees() {
        List<EmployeeResponse> listEmployeesResponse = employeeService.listAll();
        Assert.assertEquals(3L, listEmployeesResponse.size());
    }

    @Test
    public void testFindEmployeeById() throws EmployeeNotFoundException {
        EmployeeResponse employeeResponse = employeeService.findById(1L);
        Assert.assertEquals("01/03/2022", employeeResponse.getAdmissionDate());
    }

    @Test
    public void testFindEmployeeByIdIfEmployeeNotExists() {
        Assert.assertThrows(EmployeeNotFoundException.class, () -> employeeService.findById(2L));
    }

    @Test
    public void testCreateEmployee() throws ClientNotFoundException {
        EmployeeRequest request = EmployeeRequest.builder()
                .name(employeeFaker.name().name())
                .clientId(1L)
                .admissionDate(employeeFaker.numerify("##/##/####"))
                .build();

        Response response = employeeService.createEmployee(request);

        Assert.assertEquals((Integer) HttpStatus.CREATED.value(), response.getStatus());
        Assert.assertEquals("Created employee with ID 1", response.getMessage());
    }

    @Test
    public void testCreateEmployeeWithErrorForDataNotInformed() {
        EmployeeRequest request = new EmployeeRequest();

        Assert.assertThrows(ValidationException.class, () -> employeeService.createEmployee(request));
    }

    @Test
    public void testCreateEmployeeWithErrorForDateSizeInvalid() {
        EmployeeRequest request = EmployeeRequest.builder()
                .name(employeeFaker.name().name())
                .clientId(1L)
                .admissionDate(employeeFaker.numerify("##/##/#####"))
                .build();

        Assert.assertThrows(ValidationException.class, () -> employeeService.createEmployee(request));
    }

    @Test
    public void testUpdateEmployee() throws ClientNotFoundException, EmployeeNotFoundException {
        EmployeeRequest request = EmployeeRequest.builder()
                .name(employeeFaker.name().name())
                .clientId(1L)
                .admissionDate(employeeFaker.numerify("##/##/####"))
                .build();

        Response response = employeeService.updateByID(1L, request);

        Assert.assertEquals((Integer) HttpStatus.OK.value(), response.getStatus());
        Assert.assertEquals("Updated employee with ID 1", response.getMessage());
    }

    @Test
    public void testDeleteEmployee() throws EmployeeNotFoundException {
        Response response = employeeService.delete(1L);

        Assert.assertEquals((Integer) HttpStatus.OK.value(), response.getStatus());
        Assert.assertEquals("Deleted employee with ID 1", response.getMessage());
    }

 */
}
