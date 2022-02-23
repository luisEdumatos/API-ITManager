package com.api.itmanager.modules.client.service;

import com.api.itmanager.modules.client.dto.ClientRequest;
import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.client.repository.ClientRepository;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.SuccessResponse;
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
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        return ClientResponse.of(client);
    }

    public SuccessResponse createClient(ClientRequest clientRequest) {
        ClientValidation.ClientCreateValidation(clientRequest, existsByName(clientRequest.getName()), existsByCnpj(clientRequest.getCnpj()));
        Client savedClient = clientRepository.save(Client.of(clientRequest));
        return new SuccessResponse(HttpStatus.CREATED.value(), "Created client with ID " + savedClient.getId());
    }

    public SuccessResponse updateById(Long id, ClientRequest clientRequest) throws ClientNotFoundException {
        ClientResponse clientResponse = findById(id);
        ClientValidation.ClientUpdateValidation(clientRequest, clientResponse, existsByName(clientRequest.getName()), existsByCnpj(clientRequest.getCnpj()));
        var clientToUpdate = Client.of(clientRequest);
        clientToUpdate.setId(id);
        clientRepository.save(clientToUpdate);
        return new SuccessResponse(HttpStatus.OK.value(), "Updated client with ID " + clientToUpdate.getId());
    }

    public SuccessResponse delete(Long id) throws ClientNotFoundException {
        findById(id);
        clientRepository.deleteById(id);
        return new SuccessResponse(HttpStatus.OK.value(), "Deleted client with ID " + id);
    }

    public boolean existsByName(String name) {
        return clientRepository.existsByNameIgnoreCaseContaining(name);
    }

    public boolean existsByCnpj(String cnpj) {
        return clientRepository.existsByCnpj(cnpj);
    }

}
