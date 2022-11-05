package com.api.itmanager.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeDeviceNotFoundException extends RuntimeException {
    public EmployeeDeviceNotFoundException(Long employeeId, Long deviceId) {
        super("Employee " + employeeId + " and Device " + deviceId + " relationship not found.");
    }
}
