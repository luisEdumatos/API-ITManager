package com.api.itmanager.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse {
    private Integer status;
    private String message;

    public static SuccessResponse create(String message, HttpStatus httpStatus) {
        return SuccessResponse
                .builder()
                .status(httpStatus.value())
                .message(message)
                .build();
    }
}
