package com.api.itmanager.modules.device.dto;

import com.api.itmanager.modules.device.model.Device;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
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
                .client(device.getClient().getId())
                .build();
    }

}
