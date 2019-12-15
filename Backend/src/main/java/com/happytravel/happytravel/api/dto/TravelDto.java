package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReservationDto {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Long adultCost;
	private Long childCost;
	private Long entertainmentCost;
	private Long cateringCost;
	private Long alcoholCost;
	private String description;
	private Long description;
}