package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.happytravel.happytravel.api.model.enums.*;
import java.util.List;
import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "select * from reservation", nativeQuery = true)
    List<Reservation> getAllReservations();
    @Query(value = "Select * from reservation where clientID = :clientID", nativeQuery=true)
    List<Reservation> getClientReservations(@Param("clientID") Long clientID);
    @Modifying
    @Transactional
    @Query(value = "insert into reservation(id, adultnumber, alcoholtype, cateringtype, childrennumber, entertaimenttype, paymenttype, ratingtype, clientid, sellerid, travelid) values(:id, :adultnumber, :alhocoltype, :cateringtype, :childrennumber, :entertainmenttype, :paymenttype, :ratingtype, :clientid, :sellerid, :travelid)", nativeQuery = true)
    int makeReservation(@Param("id") Long id, @Param("adultnumber") Long adultNumber, @Param("alhocoltype") String alcoholtype, @Param("cateringtype") String cateringtype, @Param("childrennumber") Long childrennumber, @Param("entertainmenttype") String entertainmenttype, @Param("paymenttype") String paymenttype, @Param("ratingtype") String ratingtype, @Param("clientid") Long clientid, @Param("sellerid") Long sellerid, @Param("travelid") Long travelid);
    @Query(value = "Select max(id) from reservation", nativeQuery = true)
    Long getMaxId();
    @Modifying
    @Transactional
    @Query(value = "delete from reservation where id = :rID and clientid = :cID", nativeQuery = true)
    int cancelReservation(@Param("rID") Long rID, @Param("cID") Long cID);
    @Query(value = "Select Reservation.id from Reservation, travel where Reservation.id = :rID and Reservation.travelid = Travel.id and Travel.startdate > :date", nativeQuery = true)
    Long checkIfTravelStarted(@Param("rID") Long rID, @Param("date") Date date);
    @Query(value = "select count(*) from reservation where travelid = :tID", nativeQuery = true)
    Long countReservations(@Param("tID") Long tID);
    @Modifying
    @Transactional
    @Query(value = "delete from reservation where travelID = :tID", nativeQuery = true)
    int deleteReservationByTravelID(@Param("tID") Long tID);
    @Query(value = "select ratingtype from reservation where id = :rID", nativeQuery = true)
    String getRatingType(@Param("rID")Long rID);
    @Query(value = "Select Reservation.id from Reservation, travel where Reservation.id = :rID and Reservation.travelid = Travel.id and Travel.enddate < :date", nativeQuery = true)
    Long checkIfTravelEnded(@Param("rID") Long rID, @Param("date") Date date);
    @Modifying
    @Transactional
    @Query(value = "Update Reservation set ratingtype = :rType where id = :rID and clientID = :cID", nativeQuery = true)
    int setRatingType(@Param("rType")String rType, @Param("rID") Long rID, @Param("cID") Long cID);
}
