package ru.babaets.databaseinterface.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ru.babaets.databaseinterface.model.MurderWithKiller;

public class MurderWithKillerDAOImpl implements MurderWithKillerDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public MurderWithKillerDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MurderWithKiller> listMurderWithKiller() {
		String sql = "SELECT murders.*, killers.name AS killer_name"
				+ " FROM murders LEFT OUTER JOIN killers ON murders.killer_id = killers.killer_id";
		List<MurderWithKiller> listMurderWithKiller = jdbcTemplate.query(sql, new RowMapper<MurderWithKiller>() {

			@Override
			public MurderWithKiller mapRow(ResultSet rs, int rowNum) throws SQLException {
				MurderWithKiller murderWithKiller = new MurderWithKiller();
				
				murderWithKiller.setId(rs.getInt("murder_id"));
				murderWithKiller.setVictimName(rs.getString("victim_name"));
				murderWithKiller.setVictimGender(rs.getString("victim_gender"));
				murderWithKiller.setVictimAddress(rs.getString("victim_address"));
				murderWithKiller.setKillerName(rs.getString("killer_name"));
				
				return murderWithKiller;
			}
		});
		
		return listMurderWithKiller;
	}
}
