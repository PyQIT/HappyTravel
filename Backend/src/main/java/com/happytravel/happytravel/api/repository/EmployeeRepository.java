package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployees();
    @Modifying
    @Transactional
    @Query(value = "insert into Employee(id, firingdate, hiringdate, position, salary, officeid, personid) values (:id, :firingdate, :hiringdate, :position, :salary, :officeid, :personid)", nativeQuery = true)
    int insertEmployee(@Param("id") Long id, @Param("firingdate") Date firingdate, @Param("hiringdate") Date hiringdate, @Param("position") String position, @Param("salary") Long salary, @Param("officeid") Long officeid, @Param("personid") Long personid);
    @Query(value = "select max(id) from Employee", nativeQuery = true)
    Long getMaxId();
    @Query(value = "select distinct Employee.firingDate from Employee, User, Person where Employee.personID = Person.id and :userID = Person.userID", nativeQuery=true)
    Date getFiringDateByUserID(@Param("userID") Long userID);
}