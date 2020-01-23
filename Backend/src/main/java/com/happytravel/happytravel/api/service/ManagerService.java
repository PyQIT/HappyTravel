package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getManagers();
    Long getMaxId();
    int insertManager(Long id, Long employeeId);
    Manager getManagerByID(Long mID);
}