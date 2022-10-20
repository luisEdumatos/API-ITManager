package com.api.itmanager.modules.employee.dto;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class EmployeeResponse {

    private Long id;
    private String name;
    @JsonProperty("admission_date")
    private LocalDate admissionDate;
    @JsonProperty("integration_date")
    private LocalDate integrationDate;
    @JsonProperty("resignation_date")
    private LocalDate resignationDate;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    private ClientResponse client;

    public static EmployeeResponse of(Employee employee) {
        return EmployeeResponse
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .admissionDate(employee.getAdmissionDate())
                .integrationDate(employee.getIntegrationDate())
                .resignationDate(employee.getResignationDate())
                .phoneNumber(employee.getPhoneNumber())
                .createdAt(employee.getCreatedAt())
                .client(ClientResponse.of(employee.getClient()))
                .build();
    }
}
