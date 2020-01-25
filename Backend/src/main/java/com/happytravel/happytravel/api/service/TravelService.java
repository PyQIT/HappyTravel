package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Travel;

import java.util.List;
import java.util.Date;
public interface TravelService {

    List<Travel> getTravel();
    List<Travel> getFutureTravels(Date date);
    int addTravel(Long id, Long adultCost, Long alcoholCost, Long cateringCost, Long childCost, String description, Date endDate, Long entertainmentCost, Date startDate, Long hotelID);
    Long getMaxId();
    int deleteTravel(Long tID);
}