package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Hotel;
import com.happytravel.happytravel.api.repository.HotelRepository;
import com.happytravel.happytravel.api.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getHotels(){
        return hotelRepository.getAllHotels();
    }
    @Override
    public int addHotel(Long id,String hName, Long aID){
        return hotelRepository.addHotel(id, hName, aID);
    }
    public Long getMaxId(){
        return hotelRepository.getMaxId();
    }

}