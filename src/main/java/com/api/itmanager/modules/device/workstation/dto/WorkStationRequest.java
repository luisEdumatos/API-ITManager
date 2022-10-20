package com.api.itmanager.modules.device.workstation.dto;

import com.api.itmanager.modules.device.dto.DeviceRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class WorkStationRequest extends DeviceRequest {

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
