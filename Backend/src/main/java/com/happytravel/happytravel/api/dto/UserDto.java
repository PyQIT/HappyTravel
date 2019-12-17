package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserDto {

    private Long id;
    private String login;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
}