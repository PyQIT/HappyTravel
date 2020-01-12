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

	@Column(name = "city", nullable = false)
    @NotNull(message = "City cannot be empty.")
    private String city;

    @Column(name = "country", nullable = false)
    @NotNull(message = "Country cannot be empty.")
    private String country;

    @Column(name = "houseNr", nullable = false)
    @NotNull(message = "House cannot be empty.")
    private String houseNr;

	@Column(name = "street", nullable = false)
    @NotNull(message = "Street cannot be empty.")
    private String street;
}