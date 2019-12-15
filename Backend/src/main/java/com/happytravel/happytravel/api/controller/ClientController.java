package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ClientDto;
import com.happytravel.happytravel.api.model.Client;
import com.happytravel.happytravel.api.service.ClientService;
import com.happytravel.happytravel.api.transformer.ClientTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getClients() {
        List<Client> client = clientService.getClients();
        return client.stream().map(ClientTransformer::convertToDto).collect(Collectors.toList());
    }
}