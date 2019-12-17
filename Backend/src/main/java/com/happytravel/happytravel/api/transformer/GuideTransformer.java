package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.GuideDto;
import com.happytravel.happytravel.api.model.Guide;
import org.springframework.beans.BeanUtils;

public class GuideTransformer {

    public static GuideDto convertToDto(Guide guide) {
        GuideDto guideDto = new GuideDto();
        BeanUtils.copyProperties(guide, guideDto);
        return guideDto;
    }

    public static Guide convertToEntity(GuideDto guideDto) {
        Guide guide = new Guide();
        BeanUtils.copyProperties(guideDto, guide);
        return guide;
    }
}