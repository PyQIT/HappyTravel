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
@Table(name = "person")
public class Person{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@OneToOne
	@JoinColumn(name = "userID", referencedColumnName = "id")
	private User userID;
	
	@Column(name = "name", nullable = false)
    @NotNull(message = "name cannot be empty.")
    private String name;
	
	@Column(name = "surname", nullable = false)
    @NotNull(message = "Surname cannot be empty.")
    private String surname;
	
	@Column(name = "pesel", nullable = false)
    @NotNull(message = "PESEL number cannot be empty.")
    private Long pesel;
	
	@Column(name = "phoneNumber", nullable = false)
    @NotNull(message = "PhoneNumber cannot be empty.")
    private String phoneNumber;
	
	@Column(name = "email", nullable = false)
    @NotNull(message = "email cannot be empty.")
    private String email;
	public Long getID(){
	    return id;
    }
}