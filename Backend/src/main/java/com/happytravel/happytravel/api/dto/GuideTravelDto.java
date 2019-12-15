package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;


@Data
public class GuideTravelDto {

    private Long id;   
	private Long guideID;
	private Long travelID;
    
}