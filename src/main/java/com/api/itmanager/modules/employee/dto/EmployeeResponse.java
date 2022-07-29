package com.api.itmanager.modules.employee.dto;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private Long id;
    private String name;
    @JsonProperty("admission_date")
    private String admissionDate;
    @JsonProperty("integration_date")
    private String integrationDate;
    @JsonProperty("resignation_date")
    private String resignationDate;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
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
