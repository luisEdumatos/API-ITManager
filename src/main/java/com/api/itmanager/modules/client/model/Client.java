package com.api.itmanager.modules.client.model;

import com.api.itmanager.modules.client.dto.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CNPJ", nullable = false, unique = true)
    @Size(min = 14, max = 14)
    private String cnpj;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    public static Client of (ClientRequest request) {
        var client = new Client();
        BeanUtils.copyProperties(request, client);
        return client;
    }
}
