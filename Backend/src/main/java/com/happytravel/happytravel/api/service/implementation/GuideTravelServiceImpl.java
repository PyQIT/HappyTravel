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
    public List<GuideTravel> getGuideTravels() {
        return guideTravelRepository.getAllGuideTravels();
    }
    public Long getMaxId(){
        return guideTravelRepository.getMaxId();
    }
    public int addGuideToTravel(Long id, Long guideID, Long travelID){
        return guideTravelRepository.addGuideToTravel(id, guideID, travelID);
    }
    public int deleteByTravelID(Long tID){
        return guideTravelRepository.deleteByTravelID(tID);
    }
}

