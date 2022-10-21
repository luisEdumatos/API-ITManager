package com.api.itmanager.modules.employee_device.model;

import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.device.model.Device;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="t_employee_device")
public class EmployeeDevice {

    @EmbeddedId
    private EmployeeDeviceId employeeDeviceId;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @MapsId("deviceId")
    @JoinColumn(name = "device_id")
    Device device;
}
