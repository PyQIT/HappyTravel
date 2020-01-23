package com.happytravel.happytravel.api.service.implementation;

import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.repository.ReservationRepository;
import com.happytravel.happytravel.api.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
