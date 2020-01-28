package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.Client;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import java.util.Date;


@Data
public class PaymentMethodDto {

    private Long id;   
	private Client clientID;
	private Long cardNr;
	private Date expires;
	private String cardCode;
    
}