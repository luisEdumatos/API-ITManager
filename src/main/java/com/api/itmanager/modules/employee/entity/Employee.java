package com.api.itmanager.modules.employee.entity;

import com.api.itmanager.modules.client.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String admissionDate;

    @Column
    private String integrationDate;

    @Column
    private String resignationDate;

    @Column
    private String mainPhoneNumber;

}
