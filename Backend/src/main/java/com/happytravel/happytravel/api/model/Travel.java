package com.happytravel.happytravel.api.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Travel")

public class Travel{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate", nullable = false)
    @NotNull(message = "Start date cannot be empty.")
    private Date startDate;

    @Column(name = "endDate", nullable = false)
    @NotNull(message = "End date cannot be empty.")
    private Date endDate;

    @Column(name = "adultCost", nullable = false)
    @NotNull(message = "Adult Cost cannot be empty.")
    private Long adultCost;

    @Column(name = "childCost", nullable = false)
    @NotNull(message = "Child cost cannot be empty.")
    private Long childCost;

    @Column(name = "entertainmentCost", nullable = false)
    @NotNull(message = "Entertainment cost cannot be empty.")
    private Long entertainmentCost;
	
	@Column(name = "cateringCost", nullable = false)
    @NotNull(message = "Catering cost cannot be empty.")
    private Long cateringCost;
	
	@Column(name = "alcoholCost", nullable = false)
    @NotNull(message = "Alcohol cost cannot be empty.")
    private Long alcoholCost;
	
	@Column(name = "description", nullable = false)
    @NotNull(message = "Description cannot be empty.")
    private String description;
	
	@ManyToOne
	@JoinColumn(name = "hotelID", referencedColumnName = "id")
	private Hotel hotelID;
}