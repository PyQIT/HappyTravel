package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.ManagerDto;
import com.happytravel.happytravel.api.model.Manager;
import org.springframework.beans.BeanUtils;

public class ManagerTransformer {

    public static ManagerDto convertToDto(Manager manager) {
        ManagerDto managerDto = new ManagerDto();
        BeanUtils.copyProperties(manager, managerDto);
        return managerDto;
    }

    public static Manager convertToEntity(ManagerDto managerDto) {
        Manager manager = new Manager();
        BeanUtils.copyProperties(managerDto, manager);
        return manager;
    }
}