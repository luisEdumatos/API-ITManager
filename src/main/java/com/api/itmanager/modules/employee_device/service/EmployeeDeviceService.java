package com.api.itmanager.modules.employee_device.service;

import com.api.itmanager.modules.device.model.Device;
import com.api.itmanager.modules.device.service.DeviceService;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.service.EmployeeService;
import com.api.itmanager.modules.employee_device.model.EmployeeDevice;
import com.api.itmanager.modules.employee_device.model.EmployeeDeviceId;
import com.api.itmanager.modules.employee_device.repository.EmployeeDeviceRepository;
import com.api.itmanager.util.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeDeviceService {

    private EmployeeDeviceRepository employeeDeviceRepository;
    private EmployeeService employeeService;
    private DeviceService deviceService;

    public Response createEmployeeDevice(Long employeeId, Long deviceId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Device device = deviceService.findDeviceById(deviceId);

        EmployeeDeviceId employeeDeviceId = new EmployeeDeviceId(employeeId, deviceId);

        EmployeeDevice employeeDevice = new EmployeeDevice();
        employeeDevice.setEmployeeDeviceId(employeeDeviceId);
        employeeDevice.setEmployee(employee);
        employeeDevice.setDevice(device);

        employeeDeviceRepository.save(employeeDevice);

        return new Response("The Employee of ID " + employeeId + " and the Device of ID " + deviceId + " were successfully linked." );
    }
}
