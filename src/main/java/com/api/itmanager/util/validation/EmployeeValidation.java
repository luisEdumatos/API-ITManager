package com.api.itmanager.util.validation;

import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.util.exception.ValidationException;

public class EmployeeValidation {
    private static final int DATE_SIZE = 10;

    private EmployeeValidation() { }

    public static void employeeCreateOrUpdateValidation(EmployeeRequest request) {
        if (request.getName().isBlank()) {
            throw new ValidationException("The employee's name was not informed.");
        }

        if (request.getAdmissionDate() == null) {
            throw new ValidationException("The employee's admission date was not informed.");
        }

        if (request.getClientId() == null) {
            throw new ValidationException("The client ID was not informed.");
        }
    }
}
