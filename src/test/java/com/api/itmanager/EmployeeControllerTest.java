package com.api.itmanager;

import com.api.itmanager.modules.client.controller.ClientController;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.employee.controller.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeControllerTest extends ApiItmanagerApplicationTests {
/*
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private ClientController clientController;

    private static ClientDTO clientDTOMock;
    private static Client clientMock;
    private static EmployeeDTO employeeDTOMock;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    private void createClientDTOMock(String cnpj) {
        clientDTOMock = new ClientDTO();
        clientDTOMock.setName("Cliente Teste S/A");
        clientDTOMock.setCnpj(cnpj);
        clientDTOMock.setAddress("Avenida Teste Unitario, 123, Jardim Testes");
    }

    private void createClientMock(Long id) {
        clientMock= new Client();
        clientMock.setId(id);
        clientMock.setName(clientDTOMock.getName());
        clientMock.setCnpj(clientDTOMock.getCnpj());
        clientMock.setAddress(clientDTOMock.getAddress());
    }

    private void createEmployeeDTOMock(String admissionDate) {
        employeeDTOMock = new EmployeeDTO();
        employeeDTOMock.setClient(clientMock);
        employeeDTOMock.setName("Colaborador de Teste");
        employeeDTOMock.setAdmissionDate(admissionDate);
        employeeDTOMock.setIntegrationDate("02/01/2001");
        employeeDTOMock.setResignationDate("02/02/2022");
        employeeDTOMock.setMainPhoneNumber("35998765432");
    }

    @Test
    public void testListAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        this.createClientDTOMock("12.123.678/0001-99");
        this.createClientMock(1L);
        clientController.createClient(clientDTOMock);

        this.createEmployeeDTOMock("01/01/2001");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testCreateEmployeeWithError() throws Exception {
        this.createClientDTOMock("25.123.987/0001-08");
        this.createClientMock(1L);
        clientController.createClient(clientDTOMock);

        this.createEmployeeDTOMock("01/01/2001123");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testFindByIdIfEmployeeExists() throws Exception {
        this.createClientDTOMock("85.735.951/0002-52");
        this.createClientMock(1L);
        clientController.createClient(clientDTOMock);

        this.createEmployeeDTOMock("01/01/2001");
        employeeController.createEmployee(employeeDTOMock);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindByIdIfEmployeeNotExists() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee/25")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdateEmployee() throws Exception {
        this.createClientDTOMock("21.321.798/0001-99");
        this.createClientMock(1L);
        clientController.createClient(clientDTOMock);

        this.createEmployeeDTOMock("01/01/2001");
        employeeController.createEmployee(employeeDTOMock);


        employeeDTOMock.setClient(clientMock);
        employeeDTOMock.setName("Atualização Colaborador de Teste");
        employeeDTOMock.setAdmissionDate("01/01/2022");
        employeeDTOMock.setIntegrationDate("02/01/2022");
        employeeDTOMock.setResignationDate("02/02/2022");
        employeeDTOMock.setMainPhoneNumber("35988714685");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/employee/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateEmployeeWithError() throws Exception {
        this.createClientDTOMock("21.321.819/0002-90");
        this.createClientMock(1L);
        clientController.createClient(clientDTOMock);

        this.createEmployeeDTOMock("01/01/2001");

        employeeController.createEmployee(employeeDTOMock);

        employeeDTOMock.setClient(clientMock);
        employeeDTOMock.setName("Atualização Colaborador de Teste");
        employeeDTOMock.setAdmissionDate("01/01/20222002");
        employeeDTOMock.setIntegrationDate("02/01/2022");
        employeeDTOMock.setResignationDate("02/02/2022");
        employeeDTOMock.setMainPhoneNumber("32122112");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/employee/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

 */
}
