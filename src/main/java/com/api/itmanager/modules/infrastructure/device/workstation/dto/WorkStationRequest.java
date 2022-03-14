package com.api.itmanager.modules.infrastructure.device.workstation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkStationRequest {

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
    private String location;
    private String label;
    @JsonProperty("manufacturing_date")
    private String manufacturingDate;
    @JsonProperty("operational_system")
    private String operationalSystem;
    private String ram;
    private String hdssd;
    private String processor;
    @JsonProperty("genProcessor")
    private String genProcessor;
    private String condition;

}
