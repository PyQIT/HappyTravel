package com.happytravel.happytravel.api.service;

import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.model.enums.*;
import java.util.List;
import java.util.Date;

public interface ReservationService {

    List<Reservation> getReservations();
    List<Reservation> getClientReservations (Long clientID);
    int makeReservation(Long id, Long adultNumber, AlcoholType alcoholtype, CateringType cateringtype, Long childrennumber, EntertaimentType entertainmenttype, PaymentType paymenttype, RatingType ratingtype, Long clientid, Long sellerid, Long travelid);
    Long getMaxId();
    Long checkIfTravelStarted(Long rID, Date date);
    int cancelReservation(Long rID, Long cID);
}
