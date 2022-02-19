package com.api.itmanager.modules.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EmployeeRequest {

    @JsonProperty("client_id")
    private Long clientId;
    private String name;
    @JsonProperty("admission_date")
    private String admissionDate;
    @JsonProperty("integration_date")
    private String integrationDate;
    @JsonProperty("resignation_date")
    private String resignationDate;
    @JsonProperty("phone_number")
    private String phoneNumber;
}
