package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.HotelDto;
import com.happytravel.happytravel.api.model.Hotel;
import org.springframework.beans.BeanUtils;

public class HotelTransformer {

    public static HotelDto convertToDto(Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        BeanUtils.copyProperties(hotel, hotelDto);
        return hotelDto;
    }

    public static Hotel convertToEntity(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        BeanUtils.copyProperties(hotelDto, hotel);
        return hotel;
    }
}