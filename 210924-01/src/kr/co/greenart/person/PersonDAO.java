package kr.co.greenart.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kr.co.greenart.ConnectionProvider;

public class PersonDAO {
	public int insert(String name, int age) {
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO person (name, age) VALUES (?, ?)");) {
			stmt.setString(1, name);
			stmt.setInt(2, age);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Person> read() {
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM person");) {
			
			List<Person> personList = new ArrayList<Person>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				personList.add(new Person(id, name, age));
			}
			return personList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	
	public List<Person> read(String searchName) {
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM person WHERE name = ?");) {
			
			stmt.setString(1, searchName);
			
			List<Person> personList = new ArrayList<Person>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				personList.add(new Person(id, name, age));
			}
			return personList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
	
	public int delete(int id) {
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM person WHERE id = ?");) {
			stmt.setInt(1, id);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int update(int id, String name, int age) {
		try(Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("UPDATE person SET name = ?, age = ? WHERE id = ?");) {
			stmt.setString(1, name);
			stmt.setInt(2, age);
			stmt.setInt(3, id);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
