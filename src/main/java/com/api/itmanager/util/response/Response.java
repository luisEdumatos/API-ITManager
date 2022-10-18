package com.api.itmanager.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;

    public static Response create(String message) {
        return Response
                .builder()
                .message(message)
                .build();
    }
}
