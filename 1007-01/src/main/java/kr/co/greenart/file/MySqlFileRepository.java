package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class MySqlFileRepository implements FileRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(MultipartFile file) {
		String query = "INSERT INTO files (name, file) VALUES (?, ?)";
		try {
			jdbcTemplate.update(query, file.getOriginalFilename(), file.getBytes());
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> fileList() {
		return jdbcTemplate.queryForList("SELECT name FROM files", String.class);
	}

	@Override
	public Resource download(String fileName) {
		byte[] bytes = jdbcTemplate.queryForObject("SELECT file FROM files WHERE name = ?", byte[].class, fileName);
		Resource resource = new ByteArrayResource(bytes);
		return resource;
	}
}
