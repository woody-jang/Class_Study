import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

class UserRequest implements Serializable {
	public static final int LOGIN_REQ = 0;
	public static final int JOIN_REQ = 1;

	private int state;
	private String id;
	private String password;

	public UserRequest(int state, String id, String password) {
		this.state = state;
		this.id = id;
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserRequest [state=" + state + ", id=" + id + ", password=" + password + "]";
	}
}

class ServerResponse implements Serializable {
	public static final int LOGIN_OK = 0;
	public static final int LOGIN_FAILED = 1;
	public static final int JOIN_OK = 2;
	public static final int JOIN_FALIED = 3;

	private int state;
	private String message;

	public ServerResponse(int state, String message) {
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ServerResponse [state=" + state + ", message=" + message + "]";
	}
}

public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8902)) {
			try (Socket client = server.accept()) {
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

				UserRequest req = (UserRequest) ois.readObject();
				int state = req.getState();
				if (state == UserRequest.LOGIN_REQ) {
					System.out.println("사용자가 로그인을 요청함: " + req.getId() + "/" + req.getPassword());

					oos.writeObject(new ServerResponse(ServerResponse.LOGIN_OK, "로그인 성공"));
					oos.flush();
				} else if (state == UserRequest.JOIN_REQ) {
					System.out.println("사용자가 가입을 요청함");

					oos.writeObject(new ServerResponse(ServerResponse.JOIN_OK, "가입 성공"));
					oos.flush();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
