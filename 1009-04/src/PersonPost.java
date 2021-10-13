import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PersonPost {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/api/persons");
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestMethod("POST");
			urlConn.setRequestProperty("Content-Type", "application/json; utf-8");
			urlConn.setRequestProperty("Accept", "application/json");
			urlConn.setDoOutput(true);
			
			try (OutputStream os = urlConn.getOutputStream()) {
				String json = "{\"name\":\"New Tom\",\"age\":33}";
				os.write(json.getBytes(), 0, json.getBytes().length);
				os.flush();
			}
			
			int statusCode = urlConn.getResponseCode();
			if (statusCode == HttpURLConnection.HTTP_OK)
				System.out.println("요청 성공");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
