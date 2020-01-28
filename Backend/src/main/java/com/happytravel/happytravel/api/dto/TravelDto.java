package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import com.happytravel.happytravel.api.model.Hotel;

@Data
public class TravelDto {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Long adultCost;
	private Long childCost;
	private Long entertainmentCost;
	private Long cateringCost;
	private Long alcoholCost;
	private String description;
	private Hotel hotelID;
}