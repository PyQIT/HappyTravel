package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

@Data
public class PersonDto {

    private Long id;
	private User userID;
    private String name;
	private String surname;
	private Long pesel;
	private String phoneNumber;
	private String email;
}