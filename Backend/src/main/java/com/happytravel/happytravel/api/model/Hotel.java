package com.happytravel.happytravel.api.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Hotel")

public class Hotel{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "hotelName", nullable = false)
    @NotNull(message = "Hotel name cannot be empty.")
    private String hotelName;
	
	@ManyToOne
	@JoinColumn(name = "adresID", referencedColumnName = "id")
	private Adres adresID;
}