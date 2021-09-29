package kr.co.greenart;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@WebListener
public class ConnectionProvider implements ServletContextListener {
	private static DataSource dataSource;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션 시작시 이벤트가 발생합니다.");
		// 데이터소스 초기화
		System.out.println("데이터소스를 초기화합니다.");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/my_web");
		ds.setUsername("root");
		ds.setPassword("root");
		dataSource = ds;
	}
	
	// 커넥션 게터
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}





