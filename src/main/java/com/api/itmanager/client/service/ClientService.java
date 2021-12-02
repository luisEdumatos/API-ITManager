package com.api.itmanager.client.service;

import com.api.itmanager.client.dto.mapper.ClientMapper;
import com.api.itmanager.client.dto.request.ClientDTO;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.MessageResponseDTO;
import com.api.itmanager.client.entity.Client;
import com.api.itmanager.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    public List<ClientDTO> listall() {
        List<Client> allClients = clientRepository.findAll();
        return allClients.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO createClient(ClientDTO clientDTO) {
        Client clientToSave = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(clientToSave);
        return createMessageResponse(savedClient.getId(), "Created client with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }

    public ClientDTO findById(Long id) throws ClientNotFoundException {
        Client client = verifyExists(id);
        return clientMapper.toDTO(client);
    }

    private Client verifyExists(Long id) throws ClientNotFoundException {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new ClientNotFoundException(id);
        }
        return optionalClient.get();
    }
}
