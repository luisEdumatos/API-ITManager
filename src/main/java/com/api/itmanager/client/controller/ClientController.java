package com.api.itmanager.client.controller;

import com.api.itmanager.client.dto.request.ClientDTO;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.MessageResponseDTO;
import com.api.itmanager.client.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;

    @ApiOperation(value = "Retorna a lista de clientes existentes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de clientes, caso não existir, retorna lista vazia")
    })
    @GetMapping(produces = "application/json")
    public List<ClientDTO> listAll() {
        return clientService.listAll();
    }

    @ApiOperation(value = "Retorna o cliente informado por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o cliente referente ao ID informado"),
            @ApiResponse(code = 400, message = "Erro de passagem de parâmetro"),
            @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado"),
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.findById(id);
    }

    @ApiOperation(value = "Cria um novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Cliente criado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos campos informados"),
            @ApiResponse(code = 500, message = "Erro na criação de valores unicos já utilizados"),
    })
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.createClient(clientDTO);
    }

    @ApiOperation(value = "Atualiza dados de um cliente existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro de passagem de parâmetro"),
            @ApiResponse(code = 400, message = "Falta de ID no parâmetro"),
            @ApiResponse(code = 404, message = "Cliente não encontrado para o ID informado"),
    })
    @PutMapping(value = "/{id}", produces = "application/json")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) throws ClientNotFoundException {
        return clientService.updateById(id, clientDTO);
    }
}
