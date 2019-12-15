package com.happytravel.happytravel.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "office")
public Class Office{
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "addressid", nullable = false)
	@NotNull(message = "Adress ID cannot be empty.")
	private Long adressID;
}
