package com.api.itmanager.modules.infrastructure.device.model;

import com.api.itmanager.modules.client.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
@Table(name = "DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_CLIENT", nullable = false)
    private Client clientID;

    @Column(name = "CATEGORY", nullable = false)
    @Size(min = 2, max = 20)
    private String category;

    @Column(name = "BRAND", nullable = false)
    @Size(min = 3, max = 20)
    private String brand;

    @Column(name = "MODEL", nullable = false)
    @Size(min = 3, max = 20)
    private String model;

    @Column(name = "MAC_ADDRESS", length = 12)
    private String macAddress;

    @Column(name = "IP_ADDRESS", length = 12)
    private String ipAddress;

    @Column(name = "DESCRIPTION")
    private String description;

}
