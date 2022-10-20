package com.api.itmanager.modules.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    private String name;
    private String cnpj;
    private String address;
}
