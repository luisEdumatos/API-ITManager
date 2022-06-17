package com.api.itmanager.modules.infrastructure.device.workstation.dto;

import com.api.itmanager.modules.infrastructure.device.dto.DeviceResponse;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.workstation.model.WorkStation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
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
        BeanUtils.copyProperties(response, ws);

        return response;
    }

}
