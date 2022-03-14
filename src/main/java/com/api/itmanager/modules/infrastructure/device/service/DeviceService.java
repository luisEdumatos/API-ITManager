package com.api.itmanager.modules.infrastructure.device.service;

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
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeviceService {

    private DeviceRepository deviceRepository;
    private ClientService clientService;

    public Response createDevice(DeviceRequest request) throws ClientNotFoundException {
        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(Device.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created device with ID " + device.getId());
    }

    public Response createWorkStation(WorkStationRequest request) throws ClientNotFoundException {
        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(WorkStation.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created workstation with ID " + device.getId());
    }
}