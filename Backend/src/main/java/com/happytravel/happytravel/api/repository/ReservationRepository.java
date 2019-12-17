package com.happytravel.happytravel.api.repository;

import com.happytravel.happytravel.api.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "select * from reservation", nativeQuery = true)
    List<Reservation> getAllReservations();

}
