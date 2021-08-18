class Buffer {
	private int data;
	private boolean empty = true;

	public synchronized int get() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = true;
		notifyAll();
		return data;
	}

	public synchronized void put(int data) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		empty = false;
		this.data = data;
		notifyAll();
	}
}

class Producer implements Runnable {
	private Buffer buffer;

	public Producer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("생산자: " + i + "번째 치킨을 생산");

			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			int data = buffer.get();
			System.out.println("소비자: " + data + "번 치킨을 소비");

			try {
				Thread.sleep((int) (Math.random() * 2000));
			} catch (InterruptedException e) {
			}
		}
	}

}

public class Main2 {
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Thread prod = new Thread(new Producer(buffer));
		Thread cons = new Thread(new Consumer(buffer));

		prod.start();
		cons.start();
	}
}
