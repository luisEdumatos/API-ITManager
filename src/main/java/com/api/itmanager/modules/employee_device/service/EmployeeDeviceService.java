package com.api.itmanager.modules.employee_device.service;

import com.api.itmanager.modules.device.dto.DeviceResponse;
import com.api.itmanager.modules.device.model.Device;
import com.api.itmanager.modules.device.service.DeviceService;
import com.api.itmanager.modules.device.workstation.dto.WorkStationResponse;
import com.api.itmanager.modules.employee.model.Employee;
import com.api.itmanager.modules.employee.service.EmployeeService;
import com.api.itmanager.modules.employee_device.model.EmployeeDevice;
import com.api.itmanager.modules.employee_device.model.EmployeeDeviceId;
import com.api.itmanager.modules.employee_device.repository.EmployeeDeviceRepository;
import com.api.itmanager.util.exception.EmployeeDeviceNotFoundException;
import com.api.itmanager.util.exception.ValidationException;
import com.api.itmanager.util.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeDeviceService {

    private EmployeeDeviceRepository employeeDeviceRepository;
    private EmployeeService employeeService;
    private DeviceService deviceService;

    public Response joinEmployeeDevice(Long employeeId, Long deviceId) {
        Employee employee = employeeService.findEmployeeById(employeeId);
        Device device = deviceService.findDeviceById(deviceId);

        verifyIfClientIsTheSame(employee.getClient().getId(), device.getClient().getId());

        EmployeeDeviceId employeeDeviceId = new EmployeeDeviceId(employeeId, deviceId);

        EmployeeDevice employeeDevice = new EmployeeDevice();
        employeeDevice.setEmployeeDeviceId(employeeDeviceId);
        employeeDevice.setEmployee(employee);
        employeeDevice.setDevice(device);

        employeeDeviceRepository.save(employeeDevice);

        return new Response("The Employee of ID " + employeeId + " and the Device of ID " + deviceId + " were successfully linked." );
    }

    private void verifyIfClientIsTheSame(Long clientEmployeeId, Long clientDeviceId1) {
        if (clientEmployeeId != clientDeviceId1)
            throw new ValidationException("Employee and Device cannot be from different clients.");
    }

    public Response removeEmployeeDevice(Long employeeId, Long deviceId) {
        EmployeeDeviceId employeeDeviceId = new EmployeeDeviceId(employeeId, deviceId);

        employeeDeviceRepository.findById(employeeDeviceId).orElseThrow(() -> new EmployeeDeviceNotFoundException(employeeId, deviceId));

        employeeDeviceRepository.deleteById(employeeDeviceId);

        return new Response("Removed relationship between the employee " + employeeId + " and the equipment " + deviceId);
    }

    public List<DeviceResponse> findAllDeviceByEmployeeId(Long employeeId) {
        List<Device> devices = deviceService.findAllDeviceByEmployeeId(employeeId);

        List<DeviceResponse> responses = devices.stream()
                                                .filter(d -> d.getDtype() == 1)
                                                .map(DeviceResponse::of)
                                                .collect(Collectors.toList());

        responses.addAll(devices.stream()
                                .filter(d -> d.getDtype() == 2)
                                .map(WorkStationResponse::of)
                                .collect(Collectors.toList()));

        return responses;
    }

}
