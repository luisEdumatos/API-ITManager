package com.api.itmanager;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.util.exception.ClientNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientServiceTest extends ApiItmanagerApplicationTests {

//    @TestConfiguration
//    static class ClientServiceTestConfiguration {
//
//        @Bean
//        public ClientService clientService() {
//            return new ClientService();
//        }
//    }

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    @Before
    public void setup() {
        Client client1 = Client.builder()
                .id(1L)
                .name("Cliente Teste Service 1")
                .cnpj("12345678912345")
                .address("Avenida Cliente Teste Service, n°1234, Bairro Teste Service, Cidade Teste Service")
                .build();

        Client client2 = Client.builder()
                .id(2L)
                .name("Cliente Teste Service 2")
                .cnpj("32145678912345")
                .address("Avenida Cliente Teste Service, n°1234, Bairro Teste Service, Cidade Teste Service")
                .build();

        Client cliet3 = Client.builder()
                .id(3L)
                .name("Cliente Teste Service 3")
                .cnpj("21345678912345")
                .address("Avenida Cliente Teste Service, n°1234, Bairro Teste Service, Cidade Teste Service")
                .build();

        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2, cliet3));
        Mockito.when(clientRepository.findById(client1.getId())).thenReturn(Optional.of(client1));
    }

    @Test
    public void listAllClients() {
        List<ClientResponse> listClientsResponse = clientService.listAll();
        Assert.assertEquals(3L, listClientsResponse.size());
    }

    @Test
    public void findClientById() throws ClientNotFoundException {
        ClientResponse clientResponse = clientService.findById(1L);
        Assert.assertNotNull(clientResponse);
    }

    @Test
    public void findClientByIdIfClientNotExists() throws ClientNotFoundException {
        Assert.assertThrows(ClientNotFoundException.class, () -> clientService.findById(2L));
    }
}
