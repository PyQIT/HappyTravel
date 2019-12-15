package com.happytravel.happytravel.api.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PaymentMethod")

public class PaymentMethod{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "clientID", nullable = false)
    @NotNull(message = "Client ID cannot be empty.")
    private Long clientID;
	
	@Column(name = "cardNr", nullable = false)
    @NotNull(message = "Card Nr cannot be empty.")
    private Long cardNr;
	
	@Column(name = "expires", nullable = false)
    @NotNull(message = "Expires cannot be empty.")
    private Date expires;
	
	@Column(name = "cardCode", nullable = false)
    @NotNull(message = "Card Code cannot be empty.")
    private Long cardCode;
}