package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Manager;
import com.happytravel.happytravel.api.repository.ManagerRepository;
import com.happytravel.happytravel.api.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getManagers(){
        return managerRepository.getAllManagers();
    }

}