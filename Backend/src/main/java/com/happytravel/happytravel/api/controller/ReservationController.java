package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ReservationDto;
import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.service.ReservationService;
import com.happytravel.happytravel.api.transformer.ReservationTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
}
