package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.GuideTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<GuideTravel, Long> {

    @Query(value = "select * from guidetravel", nativeQuery = true)
    List<Travel> getAllGuideTravels();

}