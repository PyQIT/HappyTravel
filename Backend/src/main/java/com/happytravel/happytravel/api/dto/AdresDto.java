package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;


@Data
public class AdresDto {

    private Long id;   
	private String country;
	private String city;
	private String street;
	private String houseNr;
	private String apartmentNr;

    
}