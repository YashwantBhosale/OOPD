import java.lang.Thread;

class Counter {
	private int count;

	Counter() {
		count = 0;
	}

	public synchronized void increment() {
		this.count++;
	}

	public synchronized void decrement() {
		this.count--;
	}

	public synchronized int getCount() {
		return this.count;
	}
}

class Worker extends Thread {
	private Counter counter;

	Worker(Counter counter) {
		this.counter = counter;
	}

	@Override 
	public void run() {
		for(int i = 0; i < 3; i++) {
			counter.increment();
		}
		System.out.println("Counter was incremented 3 times");
	}	
}

public class Main{
	public static void main(String[] args){
		Counter counter = new Counter();

		Worker a = new Worker(counter);
		Worker b = new Worker(counter);
		Worker c = new Worker(counter);
	
		a.start();
		b.start();
		c.start();

		try {
			a.join();
			b.join();
			c.join();

		} catch (Exception e) {
			//TODO: handle exception
		}

		System.out.println("Final Count: " + counter.getCount());	
	}
}
