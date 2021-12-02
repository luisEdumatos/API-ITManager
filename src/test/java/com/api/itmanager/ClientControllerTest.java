package com.api.itmanager;

import com.api.itmanager.ApiItmanagerApplicationTests;
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

    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void testListAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateClient() throws Exception {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Cliente Teste S/A");
        clientDTO.setCnpj("12.345.678/0001-99");
        clientDTO.setAddress("Avenida Teste Unitario, 123, Jardim Testes");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/client")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testCreateClientWithError() throws Exception {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Cliente Teste S/A");
        clientDTO.setCnpj("12.345.678/0001-999");
        clientDTO.setAddress("Avenida Teste Unitario, 123, Jardim Testes");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/client")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(clientDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testFindByIdIfClientExists() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Cliente Teste S/A");
        clientDTO.setCnpj("12.123.555/0001-99");
        clientDTO.setAddress("Avenida Teste Unitario, 123, Jardim Testes");

        clientController.createClient(clientDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFindByIdIfClientNotExists() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/client/25")).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}