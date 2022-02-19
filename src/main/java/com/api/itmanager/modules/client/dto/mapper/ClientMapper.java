package com.api.itmanager.modules.client.dto.mapper;

import com.api.itmanager.modules.client.dto.request.ClientDTO;
import com.api.itmanager.modules.client.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO (Client client);
}
