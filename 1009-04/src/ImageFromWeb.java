import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

public class ImageFromWeb {
	public static void main(String[] args) {
		String yourName = JOptionPane.showInputDialog("니 이름");
		try {
			URL url = new URL("https://robohash.org/" + URLEncoder.encode(yourName, "utf-8"));
			URLConnection urlConn = url.openConnection();
			try (BufferedInputStream bis = new BufferedInputStream(urlConn.getInputStream());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("itsyou.png"))) {
				byte[] buffer = new byte[1024 * 8];
				int length;
				while ((length = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, length);
					bos.flush();
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
