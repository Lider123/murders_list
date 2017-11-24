package ru.babaets.databaseinterface.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ru.babaets.databaseinterface.model.Killer;

public class KillerDAOImpl implements KillerDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public KillerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveKiller(Killer killer) {
		String sql = "INSERT INTO killers (name)"
				+ " VALUES (?)";
		jdbcTemplate.update(sql, killer.getName());
	}

	@Override
	public void deleteKiller(int killerId) {
		String sql = "DELETE FROM killers WHERE killer_id=?";
		jdbcTemplate.update(sql, killerId);
	}

	@Override
	public Killer getKiller(int killerId) {
		String sql = "SELECT * FROM killers WHERE killer_id=?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Killer>() {

			@Override
			public Killer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next())
					return getKiller(rs);
				return null;
			}
		});
	}

	@Override
	public List<Killer> listKiller() {
		String sql = "SELECT * FROM killers";
		List<Killer> listKiller = jdbcTemplate.query(sql, new RowMapper<Killer>() {

			@Override
			public Killer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return getKiller(rs);
			}
		});
		
		return listKiller;
	}
	
	private Killer getKiller(ResultSet rs) throws SQLException {
		Killer aKiller = new Killer();
		
		aKiller.setId(rs.getInt("killer_id"));
		aKiller.setName(rs.getString("name"));
		
		return aKiller;
	}
}
