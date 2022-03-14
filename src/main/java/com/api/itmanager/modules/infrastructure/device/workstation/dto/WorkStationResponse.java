package com.api.itmanager.modules.infrastructure.device.workstation.dto;

import com.api.itmanager.modules.client.dto.ClientResponse;
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
public class WorkStationResponse {

    private Long id;
    private String category;
    private String brand;
    private String model;
    @JsonProperty("mac_address")
    private String macAddress;
    @JsonProperty("ip_address")
    private String ipAddress;
    private String description;
    private ClientResponse client;
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

    public static WorkStationResponse of (WorkStation workStation) {
        return WorkStationResponse
                .builder()
                .id(workStation.getId())
                .category(workStation.getCategory())
                .brand(workStation.getBrand())
                .model(workStation.getModel())
                .macAddress(workStation.getMacAddress())
                .ipAddress(workStation.getIpAddress())
                .description(workStation.getDescription())
                .client(ClientResponse.of(workStation.getClientID()))
                .location(workStation.getLocation())
                .label(workStation.getLabel())
                .manufacturingDate(workStation.getManufacturingDate())
                .operationalSystem(workStation.getOperationalSystem())
                .ram(workStation.getRam())
                .hdssd(workStation.getHdssd())
                .processor(workStation.getProcessor())
                .genProcessor(workStation.getGenProcessor())
                .condition(workStation.getCondition())
                .build();
    }
}
