package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.GuideTravel;

import java.util.List;

public interface GuideTravelService {

    List<GuideTravel> getGuideTravels();
    Long getMaxId();
    int addGuideToTravel(Long id, Long guideID, Long travelID);
}