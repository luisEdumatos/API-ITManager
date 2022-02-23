package com.api.itmanager.modules.employee.model;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENT", nullable = false)
    private Client client;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADMISSION_DATE", nullable = false)
    @Size(min = 10, max = 10)
    private String admissionDate;

    @Column(name = "INTEGRATION_DATE")
    @Size(min = 10, max = 10)
    private String integrationDate;

    @Column(name = "RESIGNATION_DATE")
    @Size(min = 10, max = 10)
    private String resignationDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public static Employee of(EmployeeRequest request, ClientResponse clientResponse) {
        var client = new Client();
        BeanUtils.copyProperties(clientResponse, client);

        return Employee
                .builder()
                .name(request.getName())
                .client(client)
                .admissionDate(request.getAdmissionDate())
                .integrationDate(request.getIntegrationDate())
                .resignationDate(request.getResignationDate())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}
