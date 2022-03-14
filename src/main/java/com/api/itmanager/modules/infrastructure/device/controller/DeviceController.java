package com.api.itmanager.modules.infrastructure.device.controller;

import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.service.DeviceService;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
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

    private DeviceService deviceService;

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createDevice(@RequestBody @Valid DeviceRequest request) throws ClientNotFoundException {
        return deviceService.createDevice(request);
    }

    @PostMapping(value = "/worksation",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createWorkStation(@RequestBody @Valid WorkStationRequest request) throws ClientNotFoundException {
        return deviceService.createWorkStation(request);
    }
}
