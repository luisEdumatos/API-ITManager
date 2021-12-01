package com.api.itmanager;

import com.api.itmanager.client.controller.ClientController;
import com.api.itmanager.client.dto.mapper.ClientMapper;
import com.api.itmanager.client.dto.request.ClientDTO;
import com.api.itmanager.client.entity.Client;
import com.api.itmanager.employee.controller.EmployeeController;
import com.api.itmanager.employee.dto.request.EmployeeDTO;
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

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private ClientController clientController;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testListAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/employee")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateEmployee() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Cliente Teste S/A");
        clientDTO.setCnpj("12.123.678/0001-99");
        clientDTO.setAddress("Avenida Teste Unitario, 123, Jardim Testes");

        clientController.createClient(clientDTO);

        Client client = new Client();
        client.setId(1L);
        client.setName(clientDTO.getName());
        client.setCnpj(clientDTO.getCnpj());
        client.setAddress(clientDTO.getAddress());

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setClient(client);
        employeeDTO.setName("Colaborador de Teste");
        employeeDTO.setAdmissionDate("01/01/2001");
        employeeDTO.setIntegrationDate("02/01/2001");
        employeeDTO.setResignationDate("02/02/2022");
        employeeDTO.setMainPhoneNumber("35998765432");

        System.out.println(objectMapper.writeValueAsString(employeeDTO));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/employee")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
