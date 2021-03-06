package com.happytravel.happytravel.api.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Adres")

public class Adres{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    @NotNull(message = "Country cannot be empty.")
    private String country;

    @Column(name = "city", nullable = false)
    @NotNull(message = "City cannot be empty.")
    private String city;

    @Column(name = "street", nullable = true)
    private String street;

    @Column(name = "houseNr", nullable = false)
    @NotNull(message = "City cannot be empty.")
    private String houseNr;

    @Column(name = "apartmentNr", nullable = true)
    private String apartmentNr;
}