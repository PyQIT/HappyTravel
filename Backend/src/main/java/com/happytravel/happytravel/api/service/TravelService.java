package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Travel;

import java.util.List;
import java.util.Date;
public interface TravelService {

    List<Travel> getTravel();
    List<Travel> getFutureTravels(Date date);
}