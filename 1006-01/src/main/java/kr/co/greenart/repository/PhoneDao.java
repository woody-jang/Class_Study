package kr.co.greenart.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.Phone;

@Repository
public class PhoneDao implements IPhoneDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Phone p) {
		String query = "INSERT INTO smartphones (model, production, amount, price)" + " VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, p.getModel(), p.getProduction(), p.getAmount(), p.getPrice());
	}

	@Override
	public List<Phone> getAll() {
		String query = "SELECT * FROM smartphones";
		return jdbcTemplate.query(query, new RowMapper<Phone>() {
			@Override
			public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String model = rs.getString("model");
				String production = rs.getString("production");
				int amount = rs.getInt("amount");
				int price = rs.getInt("price");
				return new Phone(id, model, production, amount, price);
			}
		});
	}
}
