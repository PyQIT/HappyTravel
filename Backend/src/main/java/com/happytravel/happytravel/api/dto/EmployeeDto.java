package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Office;
import com.happytravel.happytravel.api.model.Person;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class EmployeeDto {

    private Long id;
    private Person personID;
	private Office officeID;
	private Long salary;
	private Date hiringDate;
	private Date firingDate;
	@Enumerated(EnumType.STRING)
	private Position position;
}