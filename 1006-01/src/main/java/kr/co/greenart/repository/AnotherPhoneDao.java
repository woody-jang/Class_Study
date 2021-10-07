package kr.co.greenart.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kr.co.greenart.model.Phone;

@Repository
@Primary
public class AnotherPhoneDao implements IPhoneDAO {
	private Logger logger = LoggerFactory.getLogger(AnotherPhoneDao.class);
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public int add(Phone p) {
		logger.info("named jdbc 템플릿으로 phone을 insert 합니다");
		String query = "INSERT INTO smartphones (model, production, amount, price)"
				+ " VALUES (:model, :production, :amount, :price)";
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(p);
		return namedJdbcTemplate.update(query, namedParameters);
	}

	@Override
	public List<Phone> getAll() {
		return namedJdbcTemplate.query("SELECT * FROM smartphones", new BeanPropertyRowMapper<Phone>(Phone.class));
	}

}
