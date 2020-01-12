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
@Table(name = "user")
public class User{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", nullable = false)
    @NotNull(message = "login cannot be empty.")
    private String login;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Password cannot be empty.")
    private String password;
	
	@Column(name = "userType", nullable = false)
    @NotNull(message = "User type cannot be empty.")
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}