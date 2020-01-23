package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ManagerDto;
import com.happytravel.happytravel.api.model.Manager;
import com.happytravel.happytravel.api.service.ManagerService;
import com.happytravel.happytravel.api.transformer.ManagerTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class ManagerController {
    private final ManagerService managerService;

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<ManagerDto> getManagers() {
        List<Manager> manager = managerService.getManagers();
        return manager.stream().map(ManagerTransformer::convertToDto).collect(Collectors.toList());
    }
}