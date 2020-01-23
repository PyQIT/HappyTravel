package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Date;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query(value = "select * from travel", nativeQuery = true)
    List<Travel> getAllTravel();
    @Query(value = "select * from travel where startdate>:date", nativeQuery = true)
    List<Travel> getFutureTravels(@Param("date") Date date);

}