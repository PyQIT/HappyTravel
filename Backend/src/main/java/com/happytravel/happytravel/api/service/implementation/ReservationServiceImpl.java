package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.repository.ReservationRepository;
import com.happytravel.happytravel.api.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.happytravel.happytravel.api.model.enums.*;
import java.util.List;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public List<Reservation> getReservations(){
        return reservationRepository.getAllReservations();
    }
    @Override
    public List<Reservation> getClientReservations(Long clientID){
        return reservationRepository.getClientReservations(clientID);
    }
    public int makeReservation(Long id, Long adultNumber, String alcoholtype, String cateringtype, Long childrennumber, String entertainmenttype, String paymenttype, String ratingtype, Long clientid, Long sellerid, Long travelid){
        return reservationRepository.makeReservation(id, adultNumber, alcoholtype, cateringtype, childrennumber, entertainmenttype, paymenttype, ratingtype, clientid, sellerid, travelid);
    }
    public Long getMaxId(){
        return reservationRepository.getMaxId();
    }
    public Long checkIfTravelStarted(Long rID, Date date){
        return reservationRepository.checkIfTravelStarted(rID, date);
    }
    public int cancelReservation(Long rID, Long cID){
        return reservationRepository.cancelReservation(rID, cID);
    }
    public Long countReservations(Long tID){
        return reservationRepository.countReservations(tID);
    }
}
