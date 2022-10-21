package com.api.itmanager.modules.employee_device.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EmployeeDeviceId implements Serializable {

    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="device_id")
    private Long deviceId;
}
