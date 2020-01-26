package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ReservationDto;
import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.service.ReservationService;
import com.happytravel.happytravel.api.service.SellerService;
import com.happytravel.happytravel.api.service.UserService;
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
    private final SellerService sellerService;
    private final UserService userService;

    @GetMapping("/reservations")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDto> getReservations() {
        List<Reservation> reservation = reservationService.getReservations();
        return reservation.stream().map(ReservationTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/makeReservation")
    public int makeReservation(@RequestParam Long adultNumber, @RequestParam boolean alcoholtype, @RequestParam boolean cateringtype, @RequestParam Long childrennumber, @RequestParam boolean entertainmenttype, @RequestParam Long clientid, @RequestParam String sellerid, @RequestParam Long travelid) {
        Random rand = new Random();
        AlcoholType aType = AlcoholType.NONE;
        CateringType cType = CateringType.NONE;
        EntertaimentType eType = EntertaimentType.NONE;
        Long sellerID;
        if(alcoholtype)
            aType = AlcoholType.values()[rand.nextInt(AlcoholType.values().length-2)];
        if(cateringtype)
            cType = CateringType.values()[rand.nextInt(AlcoholType.values().length-2)];
        if(entertainmenttype)
            eType = EntertaimentType.values()[rand.nextInt(AlcoholType.values().length-2)];
        if(sellerid.equals("null"))
            sellerID=null;
        else {
            sellerID = Long.parseLong(sellerid);
            if(sellerService.getSellerIdByUserId(sellerID) == null) return -1;
        }
        return reservationService.makeReservation(reservationService.getMaxId()+1, adultNumber, aType.name(), cType.name(), childrennumber, eType.name(), null, null, userService.getClientIdByUserId(clientid), sellerID, travelid);
    }
    @GetMapping("/cancelReservation")
    public int cancelReservation(@RequestParam Long reservationID, @RequestParam Long clientID){
        if(reservationService.checkIfTravelStarted(reservationID, new Date()) == null) return -1;
        else return reservationService.cancelReservation(reservationID, userService.getClientIdByUserId(clientID));
    }
    @GetMapping("/deleteReservationByTravelID")
    public int deleteReservationByTravelID(@RequestParam Long reservationID){
        return reservationService.deleteReservationByTravelID(reservationID);
    }
    @GetMapping("/countReservations")
    public Long countReservations(@RequestParam Long travelID){
        return reservationService.countReservations(travelID);
    }
    @GetMapping("/rateTravel")
    public int rateTravel(@RequestParam String ratingType, @RequestParam Long reservationID, @RequestParam Long loggedUser){
        if(!reservationService.getRatingType(reservationID).equals("NONE")) return -1;
        if(reservationService.checkIfTravelEnded(reservationID, new Date())==null) return -2;
        RatingType[] tab = {RatingType.BAD, RatingType.AVERAGE, RatingType.OK, RatingType.GOOD, RatingType.BEST, RatingType.NONE};
        RatingType r = RatingType.NONE;
        for(int i=0;i<tab.length-1;i++){
            if(ratingType.equals(tab[i].name()))
                r=tab[i];
        }
        return reservationService.setRatingType(r.name(), reservationID, loggedUser);
    }
}
