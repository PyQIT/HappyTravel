package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class EmployeeDto {

    private Long id;
    private Long personID;
	private Long officeID;
	private Long salary;
	private Date hiringDate;
	private Date firingDate;
	@Enumerated(EnumType.STRING)
	private Position position;
}