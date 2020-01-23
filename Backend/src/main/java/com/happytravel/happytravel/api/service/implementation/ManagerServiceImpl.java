package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Manager;
import com.happytravel.happytravel.api.repository.ManagerRepository;
import com.happytravel.happytravel.api.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getManagers(){
        return managerRepository.getAllManagers();
    }
    @Override
    public Long getMaxId(){return managerRepository.getMaxId();}
    @Override
    public int insertManager(Long id, Long employeeId){ return managerRepository.insertManager(id, employeeId);}
    @Override
    public Manager getManagerByID(Long mID){ return managerRepository.getManagerByID(mID);}
    @Override
    public int fireEmployee(Long eID, Date date){
        return managerRepository.fireEmployee(eID, date);
    }
    @Override
    public Long getManagerID(Long user_ID){
        return managerRepository.getManagerID(user_ID);
    }
}