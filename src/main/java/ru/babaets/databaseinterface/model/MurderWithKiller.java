package ru.babaets.databaseinterface.model;

public class MurderWithKiller {
	
	private int id;
	private String victimName;
	private String victimGender;
	private String victimAddress;
	private String killerName;
	
	public MurderWithKiller() {
	}

	public MurderWithKiller(String victimName, String victimGender, String victimAddress, String killerName) {
		this.victimName = victimName;
		this.victimGender = victimGender;
		this.victimAddress = victimAddress;
		this.killerName = killerName;
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

	public String getKillerName() {
		return killerName;
	}

	public void setKillerName(String killerName) {
		this.killerName = killerName;
	}
}