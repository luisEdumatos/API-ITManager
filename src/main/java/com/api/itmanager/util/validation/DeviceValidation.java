package com.api.itmanager.util.validation;

import com.api.itmanager.modules.infrastructure.device.dto.DeviceRequest;
import com.api.itmanager.util.exception.ValidationException;

import static org.springframework.util.ObjectUtils.isEmpty;

public class DeviceValidation {

    public static void deviceCreateValidation(DeviceRequest request) {
        deviceGeneralValidation(request);
    }

    public static void deviceUpdateValidation() {

    }

    public static void deviceGeneralValidation(DeviceRequest request) {
        if (request.getClientID() == null) {
            throw new ValidationException("The client's id was not informed.");
        }

        if (isEmpty(request.getCategory())) {
            throw new ValidationException("The device's category was not informed.");
        }

        if (isEmpty(request.getBrand())) {
            throw new ValidationException("The device's brand was not informed.");
        }

        if (isEmpty(request.getModel())) {
            throw new ValidationException("The device's model was not informed.");
        }
    }
}
