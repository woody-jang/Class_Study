package kr.co.greenart.file;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.ConnectionProvider;

public class FileDao {
	public int insertFile(String fileName, InputStream in) {
		String query = "INSERT INTO files (name, file) VALUES (?, ?)";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setString(1, fileName);
			stmt.setBlob(2, in);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<FileInfo> listFiles() {
		List<FileInfo> list = new ArrayList<>();
		String query = "SELECT id, name FROM files";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				
				FileInfo info = new FileInfo();
				info.setId(id);
				info.setFileName(name);
				
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public FileInfo selectFile(int id) {
		String query = "SELECT id, name, file FROM files WHERE id = ?";
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(query);) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					int fileid = rs.getInt("id");
					String filename = rs.getString("name");
					byte[] file = rs.getBytes("file");
					
					return new FileInfo(fileid, filename, file);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}











