package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query(value = "select * from travel", nativeQuery = true)
    List<Travel> getAllTravel();
}