package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.EmployeeDto;
import com.happytravel.happytravel.api.model.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeTransformer {

    public static EmployeeDto convertToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    public static Employee convertToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}