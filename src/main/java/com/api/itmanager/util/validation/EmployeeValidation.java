package com.api.itmanager.util.validation;

import com.api.itmanager.modules.employee.dto.EmployeeRequest;
import com.api.itmanager.util.exception.ValidationException;

import static org.springframework.util.ObjectUtils.isEmpty;

public class EmployeeValidation {
    private static final int DATE_SIZE = 10;

    public static void employeeCreateOrUpdateValidation(EmployeeRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The employee's name was not informed.");
        }

        if (isEmpty(request.getAdmissionDate())) {
            throw new ValidationException("The employee's admission date was not informed.");
        }

        if (isEmpty(request.getClientId())) {
            throw new ValidationException("The client ID was not informed.");
        }
    }
}
