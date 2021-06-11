package com.bala.rest.webservices.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private LocalDate dateOfBirth;

	public User(int id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

	
}
