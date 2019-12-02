package com.happytravel.happytravel.api.transformer;

import com.happytravel.happytravel.api.dto.ReservationDto;
import com.happytravel.happytravel.api.model.Reservation;
import org.springframework.beans.BeanUtils;

public class ReservationTransformer {

    public static ReservationDto convertToDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        BeanUtils.copyProperties(reservation, reservationDto);
        return reservationDto;
    }

    public static Reservation convertToEntity(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto, reservation);
        return reservation;
    }
}
