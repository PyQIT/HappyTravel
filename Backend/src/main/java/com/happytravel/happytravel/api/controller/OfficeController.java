package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.OfficeDto;
import com.happytravel.happytravel.api.model.Office;
import com.happytravel.happytravel.api.service.OfficeService;
import com.happytravel.happytravel.api.transformer.OfficeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class OfficeController{
	private final OfficeService officeService;
	
	@GetMapping("/offices")
	@ResponseStatus(HttpStatus.OK)
	public List<OfficeDto> getOffices(){
		List<Office> office = officeService.getOffices();
		return office.stream().map(OfficeTransformer::convertToDto).collect(Collectors.toList());
	}
}