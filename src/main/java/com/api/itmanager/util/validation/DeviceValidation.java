package com.api.itmanager.util.validation;

import com.api.itmanager.modules.device.dto.DeviceRequest;
import com.api.itmanager.util.exception.ValidationException;

public class DeviceValidation {

    private DeviceValidation() { }

    public static void deviceCreateValidation(DeviceRequest request) {
        deviceGeneralValidation(request);
    }

    public static void deviceGeneralValidation(DeviceRequest request) {
        if (request.getClientID() == null) {
            throw new ValidationException("The client's id was not informed.");
        }

        if (request.getCategory().isBlank()) {
            throw new ValidationException("The device's category was not informed.");
        }

        if (request.getBrand().isBlank()) {
            throw new ValidationException("The device's brand was not informed.");
        }

        if (request.getModel().isBlank()) {
            throw new ValidationException("The device's model was not informed.");
        }
    }
}
