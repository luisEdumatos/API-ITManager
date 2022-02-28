package com.api.itmanager;

import com.api.itmanager.modules.client.dto.ClientRequest;
import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@RunWith(SpringRunner.class)
public class ClientServiceTest extends ApiItmanagerApplicationTests {

    private Faker clientFaker;

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository clientRepository;

    @Before
    public void setup() {
        this.clientFaker = new Faker(new Locale("pt-BR"));

        Client client1 = createClientFaker(1L);
        client1.setCnpj("12345678912345");

        Client client2 = createClientFaker(2L);

        Client cliet3 = createClientFaker(3L);

        Mockito.when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2, cliet3));
        Mockito.when(clientRepository.findById(client1.getId())).thenReturn(Optional.of(client1));
    }

    private Client createClientFaker(Long id) {
        return Client.builder()
                .id(id)
                .name(clientFaker.company().name())
                .address(clientFaker.address().fullAddress())
                .cnpj(clientFaker.numerify("##############"))
                .build();
    }

    @Test
    public void listAllClients() {
        List<ClientResponse> listClientsResponse = clientService.listAll();
        Assert.assertEquals(3L, listClientsResponse.size());
    }

    @Test
    public void findClientById() throws ClientNotFoundException {
        ClientResponse clientResponse = clientService.findById(1L);
        Assert.assertEquals(clientResponse.getCnpj(), "12345678912345");
    }

    @Test
    public void findClientByIdIfClientNotExists() throws ClientNotFoundException {
        Assert.assertThrows(ClientNotFoundException.class, () -> clientService.findById(2L));
    }
}
