package com.api.itmanager.modules.employee.model;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee_device.model.EmployeeDevice;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @OneToMany(mappedBy = "employee")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<EmployeeDevice> devices;

    @Column(nullable = false)
    private String name;

    @Column(name = "admission_date", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "integration_date")
    private LocalDate integrationDate;

    @Column(name = "resignation_date")
    private LocalDate resignationDate;

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
