import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class PersonApiClient {
	public static void main(String[] args) {
		try {
			URL personApiUrl = new URL("http://localhost:8080/api/persons");
			URLConnection urlConn = personApiUrl.openConnection();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}