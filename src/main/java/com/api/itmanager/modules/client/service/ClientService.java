package com.api.itmanager.modules.client.service;

import com.api.itmanager.modules.client.dto.ClientRequest;
import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.Response;
import com.api.itmanager.util.validation.ClientValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;

    public List<ClientResponse> listAll() {
        return clientRepository
                .findAll()
                .stream()
                .map(ClientResponse::of)
                .collect(Collectors.toList());
    }

    public ClientResponse findById(Long id) throws ClientNotFoundException {
        return clientRepository
                .findById(id)
                .map(ClientResponse::of)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Response createClient(ClientRequest clientRequest) {
        ClientValidation.clientCreateValidation(clientRequest,
                                                existsByName(clientRequest.getName()),
                                                existsByCnpj(clientRequest.getCnpj()));

        Client savedClient = clientRepository.save(Client.of(clientRequest));

        return new Response(HttpStatus.CREATED.value(), "Created client with ID " + savedClient.getId());
    }

    public Response updateById(Long id, ClientRequest clientRequest) throws ClientNotFoundException {
        ClientResponse clientResponse = findById(id);

        ClientValidation.clientUpdateValidation(clientRequest, clientResponse, existsByName(clientRequest.getName()), existsByCnpj(clientRequest.getCnpj()));

        clientRepository.save(createClientToUpdate(id, clientRequest));

        return new Response(HttpStatus.OK.value(), "Updated client with ID " + id);
    }

    private Client createClientToUpdate(Long id, ClientRequest request) {
        var clientToUpdate = Client.of(request);
        clientToUpdate.setId(id);
        return clientToUpdate;
    }

    public Response delete(Long id) throws ClientNotFoundException {
        findById(id);
        clientRepository.deleteById(id);

        return new Response(HttpStatus.OK.value(), "Deleted client with ID " + id);
    }

    public boolean existsByName(String name) {
        return clientRepository.existsByNameIgnoreCaseContaining(name);
    }

    public boolean existsByCnpj(String cnpj) {
        return clientRepository.existsByCnpj(cnpj);
    }
}