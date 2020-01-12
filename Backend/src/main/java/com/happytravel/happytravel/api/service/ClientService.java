package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> getClients();
    Long getMaxId();
    int insertClient(Long id, Long personId);
}