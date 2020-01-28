package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.GuideTravelDto;
import com.happytravel.happytravel.api.model.GuideTravel;
import com.happytravel.happytravel.api.service.GuideTravelService;
import com.happytravel.happytravel.api.transformer.GuideTravelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class GuideTravelController {

    private final GuideTravelService guideTravelService;

    @GetMapping("/guideTravels")
    @ResponseStatus(HttpStatus.OK)
    public List<GuideTravelDto> getGuideTravels() {
        List<GuideTravel> guideTravel = guideTravelService.getGuideTravels();
        return guideTravel.stream().map(GuideTravelTransformer::convertToDto).collect(Collectors.toList());
    }
    public Long getMaxId(){
        return guideTravelService.getMaxId();
    }
}