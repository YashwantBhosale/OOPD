/*
 * Problem: Two threads print numbers from 1 to N. One prints odd numbers and the other prints even numbers. Output must be in order.
 */
import java.lang.*;

class Printer {
	private final int N;
	private int i;	

	Printer(int n) {
		this.N = n;
		i = 1;
	}

	public synchronized void printOdd() {
		while(i <= N) {
			if(i%2 == 1){
				System.out.println(i);
				i++;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace(); // pretty standard practice to print what function caused the error
				}	
			}
		}			
	}
	
	public synchronized void printEven() {
		while(i <= N) {
			if(i%2 == 0){
				System.out.println(i);
				i++;
				notifyAll();
			}else{
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();	
				}
			}
		}
	}
}


public class Program1 {

	public static void main(String args[]) {
		Printer printer = new Printer(10);

		Thread t1 = new Thread(printer::printOdd);
		Thread t2 = new Thread(printer::printEven);

		t1.start();
		t2.start();
	}
}
