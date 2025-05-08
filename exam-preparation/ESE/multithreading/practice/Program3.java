/*
 * Problem: Multiple threads increment and decrement a shared counter.
 * ensure it stays within a specific range (e.g. 0-5)
 */

class Counter {
	int counter;

	Counter() {
		this.counter = 0;
	}

	public synchronized void increment() {
		while(this.counter >= 5) {
			try{
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.counter++;
		System.out.println("inc->" + counter);
		notifyAll();	
	}

	public synchronized void decrement() {
		while(this.counter<= 0){
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();	
			}
		}

		this.counter--;
		System.out.println("dec->" + counter);
		notifyAll();	
	}
}

public class Program3 {
	public static void main(String[] args) {
		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			counter.increment();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
		});

		Thread t2 = new Thread(() -> {
			counter.decrement();
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		});

		Thread t3 = new Thread(() -> {
			counter.increment();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
		});

		Thread t4 = new Thread(() -> {
			counter.increment();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
		});
		
		Thread t5 = new Thread(() -> {
			counter.decrement();
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		});

		Thread t6 = new Thread(() -> {
			counter.increment();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
		});

		Thread t7 = new Thread(() -> {
			counter.decrement();
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		});

		Thread t8 = new Thread(() -> {
			counter.decrement();
			try {
				Thread.sleep(150);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		});
		
		Thread t9 = new Thread(() -> {
			counter.increment();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			
		});
				

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
	}	
}
