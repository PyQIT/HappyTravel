package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Employee;
import com.happytravel.happytravel.api.repository.EmployeeRepository;
import com.happytravel.happytravel.api.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees(){
        return employeeRepository.getAllEmployees();
    }
    @Override
    public int insertEmployee(Long id, Date firingdate, Date hiringdate, String position, Long salary, Long officeid, Long personid){
        return employeeRepository.insertEmployee(id, firingdate, hiringdate, position, salary, officeid, personid);
    }
    @Override
    public Long getMaxId(){
        return employeeRepository.getMaxId();
    }
}