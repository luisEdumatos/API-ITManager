package com.api.itmanager.client.dto.mapper;

import com.api.itmanager.client.dto.request.ClientDTO;
import com.api.itmanager.client.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client toModel(ClientDTO clientDTO);

    ClientDTO toDTO (Client client);
}
