/*
 * Problem: Given N, create three threads
 * 1. One prints 0
 * 2. One prints even numbers
 * 3. One prints odd numbers
 */

class Printer{
	private int N;
	private int i;
	private String turn;

	Printer(int N) {
		this.N = N;
		this.i = 1;
		this.turn = "ZERO";
	}

	public synchronized void printOdd() {
		while(i <= N) {
			while(turn != "ODD") {
				try{
					wait();
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
			i++;
			turn = "ZERO";
			notifyAll();
		}			
	}

	public synchronized void printEven() {
		while(i <= N) {
			while(turn != "EVEN") {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();	
				}
			}
			System.out.println(i);
			i++;
			turn = "ZERO";
			notifyAll();
		}
	}

	public synchronized void printZero() {
		while(i <= N){
			while(turn != "ZERO") {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();	
				}
			}
			System.out.println(0);
			
			if(i%2 == 1) {
				turn = "ODD";
			}
			else if(i%2 == 0) {
				turn = "EVEN";	
			}
			notifyAll();
		}
	}
}

public class Program2{
	public static void main(String[] args) {
		Printer printer = new Printer(10);

		Thread t1 = new Thread(printer::printZero);
		Thread t2 = new Thread(printer::printOdd);
		Thread t3 = new Thread(printer::printEven);

		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();

	}
}
