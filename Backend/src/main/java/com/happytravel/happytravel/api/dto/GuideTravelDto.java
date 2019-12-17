package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Guide;
import com.happytravel.happytravel.api.model.Travel;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;


@Data
public class GuideTravelDto {

    private Long id;   
	private Guide guideID;
	private Travel travelID;
    
}