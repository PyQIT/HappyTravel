package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query(value = "select * from manager", nativeQuery = true)
    List<Manager> getAllManagers();

}