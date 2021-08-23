import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 4885)) {
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());

			Thread t = new Thread(new Runnable() {
				Scanner sc = new Scanner(System.in);

				@Override
				public void run() {
					while (true) {
						String fromKey = sc.nextLine();
						try {
							dos.writeUTF(fromKey);
							dos.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
			t.setDaemon(true);
			t.start();

			String fromServer = null;
			while ((fromServer = dis.readUTF()) != null) {
				System.out.println(fromServer);
				
				if (fromServer.equals("/quit"))
					break;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
