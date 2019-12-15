package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Guide;
import com.happytravel.happytravel.api.repository.GuideRepository;
import com.happytravel.happytravel.api.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;

    @Override
    public List<Guide> getGuides(){
        return guideRepository.getAllGuides();
    }

}