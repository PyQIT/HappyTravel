package com.happytravel.happytravel.api.dto;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class ReservationDto {
    private Long id;
    private Client clientID;
    private Seller sellerID;
    private Travel travelID;
    private Long adultNumber;
    private Long childrenNumber;
    @Enumerated(EnumType.STRING)
    private CateringType cateringType;
    @Enumerated(EnumType.STRING)
    private AlcoholType alcoholType;
    @Enumerated(EnumType.STRING)
    private EntertaimentType entertaimentType;
    @Enumerated(EnumType.STRING)
    private RatingType ratingType;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}