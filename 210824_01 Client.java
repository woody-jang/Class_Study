import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 8902)) {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			oos.writeObject(new UserRequest(UserRequest.LOGIN_REQ, "idid", "pwpw"));
			oos.flush();
			
			ServerResponse resp = (ServerResponse) ois.readObject();
			int state = resp.getState();
			if (state == ServerResponse.LOGIN_OK) {
				System.out.println(resp.getMessage());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
