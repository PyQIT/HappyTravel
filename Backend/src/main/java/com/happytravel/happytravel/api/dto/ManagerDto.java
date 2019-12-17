package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Employee;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ManagerDto {

    private Long id;
    private Employee employeeID;
}