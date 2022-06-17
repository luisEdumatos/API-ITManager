package com.api.itmanager.modules.infrastructure.device.service;

import com.api.itmanager.modules.client.service.ClientService;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceResponse;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.repository.DeviceRepository;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationResponse;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import com.api.itmanager.util.exception.ClientNotFoundException;
import com.api.itmanager.util.response.Response;
import com.api.itmanager.util.validation.DeviceValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DeviceService {

    private static final long DEVICE_TYPE = 1l;
    private static final long WORKSTATION_TYPE = 2l;

    private DeviceRepository deviceRepository;
    private ClientService clientService;

    public List<DeviceResponse> findAllDevicesByClientId(Long clientId) {
        return deviceRepository
                .findAllDevicesByTypeAndClientId(clientId, DEVICE_TYPE)
                .stream()
                .map(DeviceResponse::of)
                .toList();
    }

    public List<WorkStationResponse> findAllWorkStationsByClientId(Long clientId) {
        return deviceRepository
                .findAllDevicesByTypeAndClientId(clientId, WORKSTATION_TYPE)
                .stream()
                .map(WorkStationResponse::of)
                .toList();
    }

    public Response createDevice(DeviceRequest request) throws ClientNotFoundException {
        DeviceValidation.deviceCreateValidation(request);

        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(Device.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created device with ID " + device.getId());
    }

    public Response createWorkStation(WorkStationRequest request) throws ClientNotFoundException {
        DeviceValidation.deviceCreateValidation(request);

        var client = clientService.findById(request.getClientID());

        var device = deviceRepository.save(WorkStation.of(request, client));

        return new Response(HttpStatus.CREATED.value(), "Created workstation with ID " + device.getId());
    }

}
