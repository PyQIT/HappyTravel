package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class SellerDto {

    private Long id;
    private Long employeeID;
}