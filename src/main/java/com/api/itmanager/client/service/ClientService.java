package com.api.itmanager.client.service;

import com.api.itmanager.client.dto.mapper.ClientMapper;
import com.api.itmanager.client.dto.request.ClientDTO;
import com.api.itmanager.util.response.MessageResponseDTO;
import com.api.itmanager.client.entity.Client;
import com.api.itmanager.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private ClientRepository clientRepository;
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

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

}
