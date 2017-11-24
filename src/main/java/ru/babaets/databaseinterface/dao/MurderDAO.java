package ru.babaets.databaseinterface.dao;

import java.util.List;

import ru.babaets.databaseinterface.model.Murder;

public interface MurderDAO {
	
	public void saveOrUpdateMurder(Murder murder);
	
	public void deleteMurder(int murderId);
	
	public Murder getMurder(int murderId);
	
	public List<Murder> listMurder();
}
