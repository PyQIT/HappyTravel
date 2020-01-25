package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Date;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query(value = "select * from travel", nativeQuery = true)
    List<Travel> getAllTravel();
    @Query(value = "select * from travel where startdate>:date", nativeQuery = true)
    List<Travel> getFutureTravels(@Param("date") Date date);
    @Modifying
    @Transactional
    @Query(value = "insert into travel(id, adultcost, alcoholcost, cateringcost, childcost, description, enddate, entertainmentcost, startdate, hotelid) values(:id, :adultCost, :alcoholCost, :cateringCost, :childCost, :description, :endDate, :entertainmentCost, :startDate, :hotelID)", nativeQuery = true)
    int addTravel(@Param("id") Long id, @Param("adultCost") Long adultCost, @Param("alcoholCost") Long alcoholCost, @Param("cateringCost") Long cateringCost, @Param("childCost") Long childCost, @Param("description") String description, @Param("endDate") Date endDate, @Param("entertainmentCost") Long entertainmentCost, @Param("startDate") Date startDate, @Param("hotelID") Long hotelID);
    @Query(value = "Select max(id) from travel", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "delete from travel where id = :tID", nativeQuery = true)
    int deleteTravel(@Param("tID") Long tID);
}