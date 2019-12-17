package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.GuideTravel;
import com.happytravel.happytravel.api.repository.GuideTravelRepository;
import com.happytravel.happytravel.api.service.GuideTravelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuideTravelServiceImpl implements GuideTravelService {

    private final GuideTravelRepository guideTravelRepository;

    @Override
    public List<GuideTravel> getGuideTravels(){
        return guideTravelRepository.getAllGuideTravels();
    }

}