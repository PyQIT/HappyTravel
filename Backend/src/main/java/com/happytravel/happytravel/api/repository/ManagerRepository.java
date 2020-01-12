package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

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
}