import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestOkHttpClient {
	public static void main(String[] args) {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create("{\"name\":\"New New Tom\",\"age\":33}",
				MediaType.get("application/json; charset=utf-8"));
		Request req = new Request.Builder().url("http://localhost:8080/api/persons").post(body).build();
		Call call = client.newCall(req);
		
		try (Response resp = call.execute()) {
			System.out.println(resp.isSuccessful());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
