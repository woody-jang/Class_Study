import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static List<DataOutputStream> list = new ArrayList<DataOutputStream>();

	public static void main(String[] args) {
		System.out.println("-- 서버 시작");
		try (ServerSocket server = new ServerSocket(4885)) {
			while (true) {
				System.out.println("-- 사용자 접속 대기");
				Socket client = server.accept();
				System.out.println("-- 사용자 접속");
				ChatThread chatThread = new ChatThread(client);
				chatThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자 list에 등록
	public static void add(DataOutputStream dos) {
		synchronized (list) {
			list.add(dos);
		}
	}

	// 사용자 list에서 제거
	public static void remove(DataOutputStream dos) {
		synchronized (list) {
			list.remove(dos);
		}
	}

	public static void broadcast(String message) throws IOException {
		synchronized (list) {
			for (DataOutputStream dos : list) {
				dos.writeUTF(message);
				dos.flush();
			}
		}
	}

}

class ChatThread extends Thread {
	private Socket client;
	private DataOutputStream dos;
	private DataInputStream dis;

	public ChatThread(Socket client) {
		this.client = client;
		try {
			dos = new DataOutputStream(client.getOutputStream());
			dis = new DataInputStream(client.getInputStream());

			Server.add(dos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String line = null;
		try {
			while ((line = dis.readUTF()) != null) {
				if (line.equals("/quit")) {
					dos.writeUTF(line);
					Server.remove(dos);
					break;
				} else {
					Server.broadcast(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}