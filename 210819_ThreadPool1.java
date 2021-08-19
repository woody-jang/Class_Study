import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main4 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool(); // 알아서 쓰레드를 관리
//		ExecutorService pool = Executors.newSingleThreadExecutor(); // 1개 쓰레드를 생성
//		ExecutorService pool = Executors.newFixedThreadPool(5); //5개 쓰레드를 생성
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				for (int i = 0; i < 100; i++) {
					System.out.println(i);
				}
			}
		});
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				for (int i = 100; i < 200; i++) {
					System.out.println(i);
				}
			}
		});
		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				for (int i = 200; i < 300; i++) {
					System.out.println(i);
				}
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdownNow();
	}
}
