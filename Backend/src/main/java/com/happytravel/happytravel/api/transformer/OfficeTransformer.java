package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.OfficeDto;
import com.happytravel.happytravel.api.model.Office;
import org.springframework.beans.BeanUtils;

public class OfficeTransformer {

    public static OfficeDto convertToDto(Office office) {
        OfficeDto officeDto = new OfficeDto();
        BeanUtils.copyProperties(office, officeDto);
        return officeDto;
    }

    public static Office convertToEntity(OfficeDto officeDto) {
        Office office = new Office();
        BeanUtils.copyProperties(officeDto, office);
        return office;
    }
}