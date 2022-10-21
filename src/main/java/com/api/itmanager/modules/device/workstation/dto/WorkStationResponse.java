package com.api.itmanager.modules.device.workstation.dto;

import com.api.itmanager.modules.device.dto.DeviceResponse;
import com.api.itmanager.modules.device.workstation.model.WorkStation;
import com.api.itmanager.modules.device.model.Device;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkStationResponse extends DeviceResponse {

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

    public static WorkStationResponse of(Device workStation) {
        WorkStation ws = (WorkStation) workStation;
        WorkStationResponse response = new WorkStationResponse();
        response.setId(ws.getId());
        response.setCategory(ws.getCategory());
        response.setBrand(ws.getBrand());
        response.setModel(ws.getModel());
        response.setMacAddress(ws.getMacAddress());
        response.setIpAddress(ws.getIpAddress());
        response.setDescription(ws.getDescription());
        response.setClient(ws.getClient().getId());
        response.setLocation(ws.getLocation());
        response.setLabel(ws.getLabel());
        response.setManufacturingDate(ws.getManufacturingDate());
        response.setOperationalSystem(ws.getOperationalSystem());
        response.setRam(ws.getRam());
        response.setHdssd(ws.getHdssd());
        response.setProcessor(ws.getProcessor());
        response.setGenProcessor(ws.getGenProcessor());
        response.setCondition(ws.getCondition());

        return response;
    }
}
