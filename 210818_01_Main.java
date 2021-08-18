import java.util.Scanner;

public class Main {
	static long startTime = 0;
	static char ch = 'A';
	
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					startTime = System.currentTimeMillis();
					ch = (char) (65 + (int) (Math.random() * 27));
					System.out.println(ch);
					
					try {
						Thread.sleep(((long) (Math.random() * 5000)) + 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		System.out.println("화면에 출력되는 문자를 입력하세요~");
		t.start();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.charAt(0) == ch) {
				System.out.println(System.currentTimeMillis() - startTime);
			}
		}
	}
}
