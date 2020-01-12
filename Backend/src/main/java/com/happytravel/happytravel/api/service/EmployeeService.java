package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Employee;
import java.util.Date;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();
    int insertEmployee(Long id,  Date firingdate,  Date hiringdate,  String position,  Long salary,  Long officeid,  Long personid);
    Long getMaxId();

}