package com.happytravel.happytravel.api.model;

import com.happytravel.happytravel.api.model.enums.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee{
	@Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "personID", referencedColumnName = "id")
	private Person personID;
	
	@ManyToOne
	@JoinColumn(name = "officeID", referencedColumnName = "id")
	private Office officeID;
	
	@Column(name = "salary", nullable = false)
    @NotNull(message = "salary cannot be empty.")
    private Long salary;
	
	@Column(name = "hiringDate", nullable = false)
    @NotNull(message = "Hiring Date cannot be empty.")
    private Date hiringDate;
	
	@Column(name = "firingDate", nullable = true)
    private Date firingDate;
	
	@Column(name = "position", nullable = false)
    @NotNull(message = "Position cannot be empty.")
    @Enumerated(EnumType.STRING)
    private Position position;

    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"personID\":\"" + personID  +
                "\", \"officeID\":\"" + officeID  +
                "\", \"salary\":\"" + salary +
                "\", \"hiringDate\":\"" + hiringDate +
                "\", \"firingDate\":\"" + firingDate +
                "\", \"position\":\"" + position +
                "\"}";
    }
}