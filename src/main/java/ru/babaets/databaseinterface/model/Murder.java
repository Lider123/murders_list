package ru.babaets.databaseinterface.model;

public class Murder {
	
	private int id;
	private String victimName;
	private String victimGender;
	private String victimAddress;
	private int killerId;
	
	public Murder() {
	}

	public Murder(String victimName, String victimGender, String victimAddress, int killerId) {
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

	public int getKillerId() {
		return killerId;
	}

	public void setKillerId(int killerId) {
		this.killerId = killerId;
	}
}
