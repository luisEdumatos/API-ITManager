package com.api.itmanager.modules.infrastructure.device.dto;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationResponse;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {

    private Long id;
    private String category;
    private String brand;
    private String model;
    @JsonProperty("mac_address")
    private String macAddress;
    @JsonProperty("ip_address")
    private String ipAddress;
    private String description;
    @JsonProperty("client_id")
    private Long client;

    public static DeviceResponse of(Device device) {
        return DeviceResponse
                .builder()
                .id(device.getId())
                .category(device.getCategory())
                .brand(device.getBrand())
                .model(device.getModel())
                .macAddress(device.getMacAddress())
                .ipAddress(device.getIpAddress())
                .description(device.getDescription())
                .client(device.getClientID().getId())
                .build();
    }

}
