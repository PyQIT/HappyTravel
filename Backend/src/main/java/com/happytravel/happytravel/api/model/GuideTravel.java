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
	
	@ManyToOne
	@JoinColumn(name = "guideID", referencedColumnName = "id")
	private Guide guideID;

	@ManyToOne
	@JoinColumn(name = "travelID", referencedColumnName = "id")
	private Travel travelID;
}