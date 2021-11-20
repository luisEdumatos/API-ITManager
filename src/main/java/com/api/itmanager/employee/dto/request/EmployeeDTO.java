package com.api.itmanager.employee.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmployeeDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 10, max = 10)
    private String admissionDate;

    @Size(min = 10, max = 10)
    private String integrationDate;

    @Size(min = 10, max = 10)
    private String resignationDate;

    @Size(min = 10, max = 11)
    private String mainPhoneNumber;
}
