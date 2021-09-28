package kr.co.greenart;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionProvider extends HttpServlet {
	private static DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/my_web");
		ds.setUsername("root");
		ds.setPassword("root");
		dataSource = ds;
	}
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
