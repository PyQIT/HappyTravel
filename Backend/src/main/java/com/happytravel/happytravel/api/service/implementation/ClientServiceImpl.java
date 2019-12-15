package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Client;
import com.happytravel.happytravel.api.repository.ClientRepository;
import com.happytravel.happytravel.api.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getClients(){
        return clientRepository.getAllClients();
    }

}