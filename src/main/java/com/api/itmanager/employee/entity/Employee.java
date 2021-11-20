package com.api.itmanager.employee.entity;

import com.api.itmanager.client.entity.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
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
