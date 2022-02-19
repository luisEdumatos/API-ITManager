package com.api.itmanager.modules.client.dto;

import lombok.Data;

@Data
public class ClientRequest {

    private String name;
    private String cnpj;
    private String address;
}
