package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.TravelDto;
import com.happytravel.happytravel.api.model.Travel;
import com.happytravel.happytravel.api.service.TravelService;
import com.happytravel.happytravel.api.service.GuideService;
import com.happytravel.happytravel.api.transformer.TravelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class TravelController {

    private final TravelService travelService;
    private final GuideService guideService;

    @GetMapping("/travel")
    @ResponseStatus(HttpStatus.OK)
    public List<TravelDto> getTravel() {
        List<Travel> travel = travelService.getTravel();
        return travel.stream().map(TravelTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/futureTravels")
    public List<TravelDto> getFutureTravels(){
        List<Travel> travels = travelService.getFutureTravels(new Date());
        return travels.stream().map(TravelTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/getGuidesTravels")
    public List<TravelDto> getGuidesTravels(@RequestParam Long loggedUser){
        Long gID = guideService.getGuideIdByUserId(loggedUser);
        if(gID == null) return null;
        else {
            return travelService.getGuidesTravels(gID).stream().map(TravelTransformer::convertToDto).collect(Collectors.toList());
        }
    }
}