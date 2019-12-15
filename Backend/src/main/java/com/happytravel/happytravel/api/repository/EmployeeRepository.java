package com.happytravel.happytravel.api.employee;

import com.happytravel.happytravel.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployees();

}