package com.happytravel.happytravel.api.controller;

import com.happytravel.happytravel.api.dto.ClientDto;
import com.happytravel.happytravel.api.model.Client;
import com.happytravel.happytravel.api.model.Reservation;
import com.happytravel.happytravel.api.service.ClientService;
import com.happytravel.happytravel.api.service.ReservationService;
import com.happytravel.happytravel.api.transformer.ClientTransformer;
import com.happytravel.happytravel.api.transformer.ReservationTransformer;
import com.happytravel.happytravel.api.dto.ReservationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping()
public class ClientController {

    private final ClientService clientService;
    private final ReservationService reservationService;

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getClients() {
        List<Client> client = clientService.getClients();
        return client.stream().map(ClientTransformer::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/clientReservations")
    public List<ReservationDto> getClientReservations(@RequestParam Long loggedUser){
        List<Reservation> reservations = reservationService.getClientReservations(clientService.getClientIdByUserId(loggedUser));
        return reservations.stream().map(ReservationTransformer::convertToDto).collect(Collectors.toList());
    }
}