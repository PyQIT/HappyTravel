package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotels();
    int addHotel(Long id, String hName,Long aID);
    Long getMaxId();
}