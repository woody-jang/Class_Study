import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import kr.co.greenart.ConnectionProvider;
import kr.co.greenart.file.FileDao;
import kr.co.greenart.file.FileInfo;

public class TestFileDAO {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConnectionProvider prov = new ConnectionProvider();
		prov.init();
	}

	@Test
	public void test() {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT 1");
				ResultSet rs = stmt.executeQuery();) {
			rs.next();
			assertEquals(1, rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testSavaFile() {
		FileDao dao = new FileDao();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Administrator\\Pictures\\춘식\\춘식1.png");
			int result = dao.insertFile("춘식1.png", fis);
			assertEquals(1, result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListFile() {
		FileDao dao = new FileDao();
		List<FileInfo> list = dao.listFiles();
		System.out.println(list);
		
		assertNotEquals(0, list.size());
	}
}















