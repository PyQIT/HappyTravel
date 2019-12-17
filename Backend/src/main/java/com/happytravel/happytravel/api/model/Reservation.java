package com.happytravel.happytravel.api.model;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn(name = "clientID", referencedColumnName = "id")
	private Client clientID;

    @ManyToOne
	@JoinColumn(name = "sellerID", referencedColumnName = "id")
	private Seller sellerID;

    @ManyToOne
	@JoinColumn(name = "travelID", referencedColumnName = "id")
	private Travel travelID;

    @Column(name = "adultnumber", nullable = false)
    @NotNull(message = "Adult number cannot be empty.")
    private Long adultNumber;

    @Column(name = "childrennumber", nullable = false)
    @NotNull(message = "Children number cannot be empty.")
    private Long childrenNumber;

    @Column(name = "cateringtype", nullable = false)
    @NotNull(message = "Catering type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private CateringType cateringType;

    @Column(name = "alcoholtype", nullable = false)
    @NotNull(message = "Alcohol type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private AlcoholType alcoholType;

    @Column(name = "entertaimenttype", nullable = false)
    @NotNull(message = "Catering type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private EntertaimentType entertaimentType;

    @Column(name = "ratingtype")
    @Enumerated(EnumType.STRING)
    private RatingType ratingType;

    @Column(name = "paymenttype", nullable = false)
    @NotNull(message = "Payment type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
}