package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Adres;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;


@Data
public class OfficeDto {
	private Long id;
	private Adres adressID;
}