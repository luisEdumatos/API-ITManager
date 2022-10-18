package com.api.itmanager.modules.infrastructure.device.controller;

import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceResponse;
import com.api.itmanager.modules.infrastructure.device.service.DeviceService;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationResponse;
import com.api.itmanager.util.response.Response;
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
@RequestMapping("/api/device")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeviceController {

    private DeviceService deviceService;

    @ApiOperation(value = "Retorna a lista de Equipamentos encontrados por Id de Cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de equipamentos, caso não existir, retorna lista vazia"),
            @ApiResponse(code = 400, message = "Erro de passagem de parâmetro")
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public List<DeviceResponse> findAllDevicesByClientId(@PathVariable Long id) {
        return deviceService.findAllDevicesByClientId(id);
    }

    @ApiOperation(value = "Retorna a lista de Estações de trabalho encontradas por Id de Cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de Estações de trabalho, caso não existir, retorna lista vazia"),
            @ApiResponse(code = 400, message = "Erro de passagem de parâmetro")
    })
    @GetMapping(value = "/workstation/{id}", produces = "application/json")
    public List<WorkStationResponse> findAllWorkStationsByClientId(@PathVariable Long id) {
        return deviceService.findAllWorkStationsByClientId(id);
    }

    @ApiOperation(value = "Cria um novo Equipamento")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Equipamento criado com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos campos informados"),
    })
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createDevice(@RequestBody @Valid DeviceRequest request) {
        return deviceService.createDevice(request);
    }

    @ApiOperation(value = "Cria uma nova Estação de trabalho")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Estação de trabalho criada com sucesso"),
            @ApiResponse(code = 400, message = "Erro na validação dos campos informados"),
    })
    @PostMapping(value = "/worksation",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createWorkStation(@RequestBody @Valid WorkStationRequest request) {
        return deviceService.createWorkStation(request);
    }

    /*
    @ApiOperation(value = "Deleta equipamento informado pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipamento deletado com sucesso"),
            @ApiResponse(code = 405, message = "Falta de ID no parâmetro"),
            @ApiResponse(code = 404, message = "Equipamento não encontrado para o ID informado"),
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteById(@PathVariable Long id) {
        return deviceService.delete(id);
    }

     */
}
