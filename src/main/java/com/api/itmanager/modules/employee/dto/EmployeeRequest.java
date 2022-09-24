package com.api.itmanager.modules.employee.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    @JsonProperty("client_id")
    private Long clientId;
    private String name;
    @JsonProperty("admission_date")
    private LocalDate admissionDate;
    @JsonProperty("integration_date")
    private LocalDate integrationDate;
    @JsonProperty("resignation_date")
    private LocalDate resignationDate;
    @JsonProperty("phone_number")
    private String phoneNumber;
}
