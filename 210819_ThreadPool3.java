import java.util.concurrent.*;

public class Main6 {
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		Future<Integer> f = pool.schedule(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return 1;
			}
		}, 5, TimeUnit.SECONDS);
		
		pool.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("1초 마다");
			}
		}, 0, 1, TimeUnit.SECONDS);
		
		try {
			System.out.println(f.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		pool.shutdown();
	}
}
