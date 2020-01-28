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
@Table(name = "manager")
public class Manager{

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
	@JoinColumn(name = "employeeID", referencedColumnName = "id")
	private Employee employeeID;

    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"employeeID\":\"" + employeeID +
                "\"}";
    }
}