package ru.babaets.databaseinterface.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ru.babaets.databaseinterface.model.Murder;

public class MurderDAOImpl implements MurderDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public MurderDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdateMurder(Murder murder) {
		if (murder.getId() > 0) {
			// update
			String sql = "UPDATE murders"
					+ " SET victim_name=?, victim_gender=?, victim_address=?, killer_id=?"
					+ " WHERE murder_id=?";
			jdbcTemplate.update(sql, murder.getVictimName(), murder.getVictimGender(), murder.getVictimAddress(),
					murder.getKillerId(), murder.getId());
		}
		else {
			// insert
			String sql = "INSERT INTO murders (victim_name, victim_gender, victim_address, killer_id)"
					+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, murder.getVictimName(), murder.getVictimGender(), murder.getVictimAddress(),
					murder.getKillerId());
		}
	}

	@Override
	public void deleteMurder(int murderId) {
		String sql = "DELETE FROM murders WHERE murder_id=?";
		jdbcTemplate.update(sql, murderId);
	}

	@Override
	public Murder getMurder(int murderId) {
		String sql = "SELECT * FROM murders WHERE murder_id=?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Murder>() {

			@Override
			public Murder extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return getMurder(rs);
				}
				return null;
			}
		});
	}

	@Override
	public List<Murder> listMurder() {
		String sql = "SELECT * FROM murders";
		List<Murder> listMurder = jdbcTemplate.query(sql, new RowMapper<Murder>() {

			@Override
			public Murder mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getMurder(rs);
			}
		});
		return listMurder;
	}
	
	private Murder getMurder(ResultSet rs) throws SQLException {
		Murder aMurder = new Murder();
		
		aMurder.setId(rs.getInt("murder_id"));
		aMurder.setVictimName(rs.getString("victim_name"));
		aMurder.setVictimGender(rs.getString("victim_gender"));
		aMurder.setVictimAddress(rs.getString("victim_address"));
		aMurder.setKillerId(rs.getInt("killer_id"));
		
		return aMurder;
	}
}
