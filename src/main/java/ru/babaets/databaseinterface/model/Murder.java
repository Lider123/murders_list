package ru.babaets.databaseinterface.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Murder {
	
	@NotNull
	private int id;
	
	@NotEmpty(message = "Enter victim name!")
	@Size(max = 40)
	private String victimName;
	
	@NotEmpty(message = "Enter victim gender!")
	@Pattern(regexp = "^[mf]{1}$", message = "Enter single character \'m\' or \'f\'!")
	private String victimGender = "m";
	
	@Size(max = 40)
	private String victimAddress;
	
	@Pattern(regexp = "^[0-9]*$", message = "Enter an integer!")
	private String killerId = "";
	
	public Murder() {
	}

	public Murder(String victimName, String victimGender, String victimAddress, String killerId) {
		this.victimName = victimName;
		this.victimGender = victimGender;
		this.victimAddress = victimAddress;
		this.killerId = killerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getVictimGender() {
		return victimGender;
	}

	public void setVictimGender(String victimGender) {
		this.victimGender = victimGender;
	}

	public String getVictimAddress() {
		return victimAddress;
	}

	public void setVictimAddress(String victimAddress) {
		this.victimAddress = victimAddress;
	}

	public String getKillerId() {
		return killerId;
	}

	public void setKillerId(String killerId) {
		this.killerId = killerId;
	}
}
