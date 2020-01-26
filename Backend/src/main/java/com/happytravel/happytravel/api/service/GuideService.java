package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Guide;

import java.util.List;

public interface GuideService {

    List<Guide> getGuides();
    Long getMaxId();
    int insertGuide(Long id, Long employeeId);
    Long getGuideIdByUserId(Long uID);
}