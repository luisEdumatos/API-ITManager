package com.api.itmanager.modules.infrastructure.device.workstation.model;

import com.api.itmanager.modules.client.model.Client;
import com.api.itmanager.modules.infrastructure.device.model.Device;
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
@DiscriminatorValue("2")
public class WorkStation extends Device {

    @Column(name = "LOCATION", nullable = false)
    @Size(min = 2, max = 20)
    private String location;

    @Column(name = "CATEGORY", nullable = false)
    @Size(min = 2, max = 20)
    private String category;

    @Column(name = "LABEL", nullable = false)
    @Size(min = 2, max = 20)
    private String label;

    @Column(name = "MANUFACTURING_DATE", nullable = false)
    @Size(min = 2, max = 20)
    private String manufacturingDate;

    @Column(name = "OPERATIONAL_SYSTEM", nullable = false)
    @Size(min = 2, max = 20)
    private String operationalSystem;

    @Column(name = "RAM", nullable = false)
    @Size(min = 2, max = 20)
    private String ram;

    @Column(name = "HDSSD", nullable = false)
    @Size(min = 2, max = 20)
    private String hdssd;

    @Column(name = "PROCESSOR", nullable = false)
    @Size(min = 2, max = 20)
    private String processor;

    @Column(name = "GEN_PROCESSOR", nullable = false)
    @Size(min = 2, max = 20)
    private String genProcessor;

    @Column(name = "CONDITION", nullable = false)
    @Size(min = 2, max = 20)
    private String condition;
}
