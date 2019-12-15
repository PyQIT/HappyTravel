package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.GuideTravelDto;
import com.happytravel.happytravel.api.model.GuideTravel;
import org.springframework.beans.BeanUtils;

public class GuideTravelTransformer {

    public static GuideTravelDto convertToDto(GuideTravel guideTravel) {
        GuideTravelDto guideTravelDto = new GuideTravelDto();
        BeanUtils.copyProperties(guideTravel, guideTravelDto);
        return guideTravelDto;
    }

    public static GuideTravel convertToEntity(GuideTravelDto guideTravelDto) {
        GuideTravel guideTravel = new GuideTravel();
        BeanUtils.copyProperties(guideTravelDto, guideTravel);
        return guideTravel;
    }
}