import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

class MyDB implements Runnable {
	public MyDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void insertInt(int i) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO test (input) VALUES (?)");){
			stmt.setInt(1, i);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		for (int i = 200; i <= 300; i++) {
			insertInt(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("DB 작업 종료");
	}
}

class MyFrame extends JFrame {
	private JLabel lblNum;
	private int number;
	private Timer timer;
	
	public MyFrame() {
		number = 100;
		lblNum = new JLabel(String.valueOf(number));
		lblNum.setFont(new Font("굴림", Font.PLAIN, 30));
		
		add(lblNum);
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				number++;
				lblNum.setText(String.valueOf(number));
				
				if (number == 200) {
					System.out.println("스윙 작업 종료");
					timer.stop();
				}
			}
		});
		timer.start();
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Main2 {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MyFrame();
			}
		});
		
		Thread dbThread = new Thread(new MyDB());
		dbThread.start();
		
		for (int i = 0; i <= 100; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("콘솔 출력 완료");
	}
}
