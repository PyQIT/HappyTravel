package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ReservationDto;
import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.service.ReservationService;
import com.happytravel.happytravel.api.transformer.ReservationTransformer;
import com.happytravel.happytravel.api.model.enums.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Date;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/reservations")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> getReservations() {
        List<Reservation> reservation = reservationService.getReservations();
        return reservation.stream().map(ReservationTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/makeReservation")
    public int makeReservation(@RequestParam Long adultNumber, @RequestParam boolean alcoholtype, @RequestParam boolean cateringtype, @RequestParam Long childrennumber, @RequestParam boolean entertainmenttype, @RequestParam Long clientid, @RequestParam Long travelid) {
        Random rand = new Random();
        AlcoholType aType = AlcoholType.NONE;
        CateringType cType = CateringType.NONE;
        EntertaimentType eType = EntertaimentType.NONE;
        if(alcoholtype)
            aType = AlcoholType.values()[rand.nextInt(AlcoholType.values().length-1)];
        if(cateringtype)
            cType = CateringType.values()[rand.nextInt(AlcoholType.values().length-1)];
        if(entertainmenttype)
            eType = EntertaimentType.values()[rand.nextInt(AlcoholType.values().length-1)];
        return reservationService.makeReservation(reservationService.getMaxId()+1, adultNumber, aType.name(), cType.name(), childrennumber, eType.name(), null, null, clientid, null, travelid);
    }
    @GetMapping("/cancelReservation")
    public int cancelReservation(@RequestParam Long reservationID, @RequestParam Long clientID){
        if(reservationService.checkIfTravelStarted(reservationID, new Date()) == null) return -1;
        else return reservationService.cancelReservation(reservationID, clientID);
    }
}
