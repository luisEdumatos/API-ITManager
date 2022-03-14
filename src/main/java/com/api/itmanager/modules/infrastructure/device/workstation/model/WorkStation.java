package com.api.itmanager.modules.infrastructure.device.workstation.model;

import com.api.itmanager.modules.client.dto.ClientResponse;
import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.modules.infrastructure.device.model.Device;
import com.api.itmanager.modules.infrastructure.device.workstation.dto.WorkStationRequest;
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
@DiscriminatorValue("2")
public class WorkStation extends Device {

    @Column(name = "LOCATION")
    @Size(min = 2, max = 20)
    private String location;

    @Column(name = "LABEL")
    @Size(min = 2, max = 20)
    private String label;

    @Column(name = "MANUFACTURING_DATE")
    @Size(min = 2, max = 20)
    private String manufacturingDate;

    @Column(name = "OPERATIONAL_SYSTEM")
    @Size(min = 2, max = 20)
    private String operationalSystem;

    @Column(name = "RAM")
    @Size(min = 2, max = 20)
    private String ram;

    @Column(name = "HDSSD")
    @Size(min = 2, max = 20)
    private String hdssd;

    @Column(name = "PROCESSOR")
    @Size(min = 2, max = 20)
    private String processor;

    @Column(name = "GEN_PROCESSOR")
    @Size(min = 2, max = 20)
    private String genProcessor;

    @Column(name = "CONDITION")
    @Size(min = 2, max = 20)
    private String condition;

    public static WorkStation of(WorkStationRequest request, ClientResponse clientResponse) {
        var client = new Client();
        BeanUtils.copyProperties(clientResponse, client);

        var device = new WorkStation();
        device.setClientID(client);
        device.setBrand(request.getBrand());
        device.setCategory(request.getCategory());
        device.setDescription(request.getDescription());
        device.setIpAddress(request.getIpAddress());
        device.setMacAddress(request.getMacAddress());
        device.setModel(request.getModel());
        device.setLocation(request.getLocation());
        device.setLabel(request.getLabel());
        device.setManufacturingDate(request.getManufacturingDate());
        device.setOperationalSystem(request.getOperationalSystem());
        device.setRam(request.getRam());
        device.setHdssd(request.getHdssd());
        device.setProcessor(request.getProcessor());
        device.setGenProcessor(request.getGenProcessor());
        device.setCondition(request.getCondition());

        return device;
    }
}
