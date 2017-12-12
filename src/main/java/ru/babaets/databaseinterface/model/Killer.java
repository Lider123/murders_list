package ru.babaets.databaseinterface.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Killer {
	
	@NotNull
	private int id;
	
	@NotEmpty(message = "Enter killer name!")
	private String name;
	
	public Killer() {
	}

	public Killer(String name) {
		this.name = name;
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
}
