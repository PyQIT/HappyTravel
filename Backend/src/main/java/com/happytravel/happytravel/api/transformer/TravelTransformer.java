package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.TravelDto;
import com.happytravel.happytravel.api.model.Travel;
import org.springframework.beans.BeanUtils;

public class TravelTransformer {

    public static TravelDto convertToDto(Travel travel) {
        TravelDto travelDto = new TravelDto();
        BeanUtils.copyProperties(travel, travelDto);
        return travelDto;
    }

    public static Travel convertToEntity(TravelDto travelDto) {
        Travel travel = new Travel();
        BeanUtils.copyProperties(travelDto, travel);
        return travel;
    }
}