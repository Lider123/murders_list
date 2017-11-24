package ru.babaets.databaseinterface.model;

public class Killer {
	
	private int id;
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
