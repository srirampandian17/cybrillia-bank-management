package com.cybrilla.bankmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	private String firstName;
	private String lastName;
	private String emailId;

	@ManyToOne
	@JoinColumn(name = "bank_id")
	private Bank bank;


}
