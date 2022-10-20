package com.api.itmanager.util.response;

import lombok.*;

@Getter
@Setter
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
