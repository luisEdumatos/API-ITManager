package com.api.itmanager.modules.infrastructure.device.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequest {

    @JsonProperty("client_id")
    private Long clientID;
    private String category;
    private String brand;
    private String model;
    @JsonProperty("mac_address")
    private String macAddress;
    @JsonProperty("ip_address")
    private String ipAddress;
    private String description;
}
