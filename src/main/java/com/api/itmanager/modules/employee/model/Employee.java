package com.api.itmanager.modules.employee.model;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_employee_device",
            joinColumns = { @JoinColumn(name = "employee_id") },
            inverseJoinColumns = { @JoinColumn(name = "device_id") })
    private Set<Device> devices = new HashSet<>();

    @Column(nullable = false)
    private String name;

    @Column(name = "admission_date", nullable = false)
    @Size(min = 10, max = 10)
    private String admissionDate;

    @Column(name = "integration_date")
    @Size(min = 10, max = 10)
    private String integrationDate;

    @Column(name = "resignation_date")
    @Size(min = 10, max = 10)
    private String resignationDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
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
