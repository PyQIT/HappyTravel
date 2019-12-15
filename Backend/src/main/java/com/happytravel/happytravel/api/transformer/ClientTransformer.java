package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.ClientDto;
import com.happytravel.happytravel.api.model.Client;
import org.springframework.beans.BeanUtils;

public class ClientTransformer {

    public static ClientDto convertToDto(Client client) {
        ClientDto clientDto = new ClientDto();
        BeanUtils.copyProperties(client, clientDto);
        return clientDto;
    }

    public static Client convertToEntity(ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return client;
    }
}