package com.happytravel.happytravel.api.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GuideTravel")

public class GuideTravel{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "guideID", nullable = false)
    @NotNull(message = "Guide ID cannot be empty.")
    private Long guideID;

	@Column(name = "travelID", nullable = false)
    @NotNull(message = "Travel ID cannot be empty.")
    private Long travelID;
}