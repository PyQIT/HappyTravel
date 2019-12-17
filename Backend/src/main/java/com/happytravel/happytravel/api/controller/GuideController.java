package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.GuideDto;
import com.happytravel.happytravel.api.model.Guide;
import com.happytravel.happytravel.api.service.GuideService;
import com.happytravel.happytravel.api.transformer.GuideTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class GuideController {

    private final GuideService guideService;

    @GetMapping("/guides")
    @ResponseStatus(HttpStatus.OK)
    public List<GuideDto> getGuides() {
        List<Guide> guide = guideService.getGuides();
        return guide.stream().map(GuideTransformer::convertToDto).collect(Collectors.toList());
    }
}