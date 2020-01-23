package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Travel;
import com.happytravel.happytravel.api.repository.TravelRepository;
import com.happytravel.happytravel.api.service.TravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    @Override
    public List<Travel> getTravel(){
        return travelRepository.getAllTravel();
    }
    public List<Travel> getFutureTravels(Date date){ return travelRepository.getFutureTravels(date);}

}