package com.api.itmanager.modules.infrastructure.device.controller;

import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.repository.DeviceRepository;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/device")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeviceController {

    private DeviceRepository deviceRepository;
    private ClientService clientService;

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createDevice(@RequestBody @Valid DeviceRequest request) throws ClientNotFoundException {

        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(Device.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created device with ID " + device.getId());
    }

    @PostMapping(value = "/worksation",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createWorkStation(@RequestBody @Valid WorkStationRequest request) throws ClientNotFoundException {

        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(WorkStation.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created workstation with ID " + device.getId());
    }
}
