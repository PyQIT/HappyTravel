package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Adres;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;


@Data
public class HotelDto {

    private Long id;   
	private String hotelName;
    private Adres adresID;
    
}