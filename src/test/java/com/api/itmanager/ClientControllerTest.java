package com.api.itmanager;

import com.api.itmanager.client.controller.ClientController;
import com.api.itmanager.client.dto.request.ClientDTO;
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
public class ClientControllerTest extends ApiItmanagerApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientController clientController;

    private static ClientDTO clientDTOMock;

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    private void createClientDTOMock(String cnpj) {
        clientDTOMock = new ClientDTO();
        clientDTOMock.setName("Cliente Teste S/A");
        clientDTOMock.setCnpj(cnpj);
        clientDTOMock.setAddress("Avenida Teste Unitario, 123, Jardim Testes");
    }

    @Test
    public void testListAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateClient() throws Exception {
        this.createClientDTOMock("12.345.678/0001-99");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/client")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testCreateClientWithError() throws Exception {
        this.createClientDTOMock("12.345.678/0001-999");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/client")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testFindByIdIfClientExists() throws Exception {
        this.createClientDTOMock("12.123.555/0001-99");
        clientController.createClient(clientDTOMock);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindByIdIfClientNotExists() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client/25")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdateClient() throws Exception{
        this.createClientDTOMock("85.159.351/0002-15");
        clientController.createClient(clientDTOMock);
        clientDTOMock.setName("Novo Nome Teste");
        clientDTOMock.setCnpj("15.159.351/0002-15");
        clientDTOMock.setAddress("Novo avenida dos Testes, 123");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/client/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateClientWithError() throws Exception{
        this.createClientDTOMock("85.999.351/0003-15");
        clientController.createClient(clientDTOMock);
        clientDTOMock.setName("Novo Nome Teste");
        clientDTOMock.setCnpj("15.159.351/0002-15123456");
        clientDTOMock.setAddress("Novo avenida dos Testes, 123");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/client/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTOMock)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}