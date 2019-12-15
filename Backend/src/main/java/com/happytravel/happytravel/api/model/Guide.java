package com.happytravel.happytravel.api.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Guide")

public class Guide{
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "employeeID", nullable = false)
    @NotNull(message = "Employee ID cannot be empty.")
    private Long employeeName;

}