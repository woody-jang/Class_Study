import java.util.concurrent.*;

class TaskWithResult implements Callable<Integer> {
	private int sum;

	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 100000; i++) {
			sum += i;
		}
		return sum;
	}
}

public class Main5 {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		Future<Integer> futureResult = pool.submit(new TaskWithResult());
		
		try {
			Integer sum = futureResult.get(1, TimeUnit.MICROSECONDS);
			System.out.println(sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("계산 아직 안끝남");
			try {
				Integer sum = futureResult.get(1, TimeUnit.MILLISECONDS);
				System.out.println(sum);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			} catch (TimeoutException e1) {
				e1.printStackTrace();
			}
		}
		
		pool.shutdown();
	}
}
