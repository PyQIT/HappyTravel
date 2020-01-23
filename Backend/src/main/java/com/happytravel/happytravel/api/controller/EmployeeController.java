package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.EmployeeDto;
import com.happytravel.happytravel.api.model.Employee;
import com.happytravel.happytravel.api.service.EmployeeService;
import com.happytravel.happytravel.api.transformer.EmployeeTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDto> getEmployees() {
        List<Employee> employee = employeeService.getEmployees();
        return employee.stream().map(EmployeeTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/getEmployee")
    public EmployeeDto getEmployee(@RequestParam Long id){
        Employee employee = employeeService.getEmployee(id);
        return EmployeeTransformer.convertToDto(employee);
    }
}