import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Locky {
	private int count = 0;
	private Lock myLock = new ReentrantLock();

	public void increment() {
		myLock.lock();
		try {
			count++;
		} finally {
			myLock.unlock();
		}
	}

	public void decrement() {
		myLock.lock();
		try {
			count--;
		} finally {
			myLock.unlock();
		}
	}

	public int getCount() {
		myLock.lock();
		try {
			return count;
		} finally {
			myLock.unlock();
		}
	}
}

public class Main7 {
	public static void main(String[] args) {
		Locky l = new Locky();
		ExecutorService pool = Executors.newCachedThreadPool();
		
		pool.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					l.increment();
				}
			}
		});
		
		pool.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					l.increment();
				}
			}
		});
		
		pool.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					l.increment();
				}
			}
		});
		
		try {
			pool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("최종값 :  " + l.getCount());
	}
}
