package ru.babaets.databaseinterface.dao;

import java.util.List;

import ru.babaets.databaseinterface.model.Killer;

public interface KillerDAO {
	
	public void saveKiller(Killer killer);
	
	public void deleteKiller(int killerId);
	
	public Killer getKiller(int killerId);
	
	public List<Killer> listKiller();
}
