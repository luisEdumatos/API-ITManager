package com.api.itmanager.modules.infrastructure.device.model;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE",
        discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("1")
@Table(name = "DEVICE")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DTYPE", insertable = false, updatable = false)
    private Long dtype;

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

    public static Device of(DeviceRequest request, ClientResponse clientResponse) {
        var client = new Client();
        BeanUtils.copyProperties(clientResponse, client);

        var device = new Device();
        device.setClientID(client);
        device.setBrand(request.getBrand());
        device.setCategory(request.getCategory());
        device.setDescription(request.getDescription());
        device.setIpAddress(request.getIpAddress());
        device.setMacAddress(request.getMacAddress());
        device.setModel(request.getModel());

        return device;
    }

}
