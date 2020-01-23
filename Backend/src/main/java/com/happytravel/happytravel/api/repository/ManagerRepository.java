package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query(value = "select * from manager", nativeQuery = true)
    List<Manager> getAllManagers();
    @Query(value = "select max(id) from manager", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "insert into manager(id, employeeId) values(:id, :employeeId)", nativeQuery = true)
    int insertManager(@Param("id") Long id, @Param("employeeId") Long employeeId);
    @Query(value = "Select * from Manager where id = :mID", nativeQuery = true)
    Manager getManagerByID(@Param("mID") Long mID);
    @Modifying
    @Transactional
    @Query(value = "update Employee set firingdate = :date where id = :eID", nativeQuery = true)
    int fireEmployee(@Param("eID") Long eID, @Param("date") Date date);
    @Query(value = "SELECT Manager.id from Manager, Employee , Person  WHERE Employee.id = Manager.EmployeeID AND Person.id = Employee.personID AND Person.userID = :user_ID", nativeQuery = true)
    Long getManagerID(@Param("user_ID") Long user_ID);

}