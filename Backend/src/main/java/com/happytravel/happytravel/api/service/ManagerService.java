package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Manager;

import java.util.List;
import java.util.Date;

public interface ManagerService {

    List<Manager> getManagers();
    Long getMaxId();
    int insertManager(Long id, Long employeeId);
    Manager getManagerByID(Long mID);
    int fireEmployee(Long eID, Date date);
    Long getManagerID(Long user_ID);
    int updateSalary(Long salary, Long eID);
    int updateOffice(Long oID, Long eID);
    int updatePosition(String position, Long eID);
}