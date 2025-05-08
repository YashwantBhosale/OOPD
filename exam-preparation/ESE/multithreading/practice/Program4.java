/*
 * Problem: Classic concurrent bank transaction problem
 */

class BankAccount {
	private double balance;
	private final String name;
	private final String type;

	BankAccount(String name, String type) {
		this.name = name;
		this.type = type;
		this.balance = 1000;
	}
	
	public synchronized void deposit(double amount) {
		
		System.out.println("\n Thread -> " + Thread.currentThread().getName());
		this.balance += amount;
		System.out.println(name + " deposited " + amount + "Rs. New balance: " + this.balance);
		notifyAll();
	}

	/*
	 * problem: there might be a concurrent deposit transaction with withdraw transaction,
	 * if withdraw gets the system resource first then it must wait until deposit is completed
	 * so we have to make it wait that's sure
	 * but if the withdraw function waits forever that would be a deadlock. i mean if no transaction
	 * makes the balance sufficient for withdrawal then thread must quit.
	 * for this we need to use timeout of say 5s.
	 * thread will wait for 5s and check if any concurrent transaction makes the balance enough to withdraw.
	 * if not it will return gracefully reporting insufficient bank balance
	 */
	public synchronized boolean withdraw(double amount) {
		long endTime = System.currentTimeMillis() + 5000;
		while(balance < amount) {
			long remaining = endTime - System.currentTimeMillis();
			if (remaining <= 0) {
				System.err.println("Insufficient Bank Balance!");
				System.out.println(Thread.currentThread().getName() + " timed out!");
				return false;
			}

			try {
				wait(remaining);
			} catch (Exception e) {
				e.printStackTrace();	
			}
		}

		balance -= amount;
		System.out.println(name + " withdrew " + amount + "Rs. New Balance: " + this.balance);
	
		return true;
	}
}

public class Program4 {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("Alhad", "Savings");

		Thread[] threads = new Thread[16];

		// 8 Withdraw threads
		threads[0] = new Thread(() -> account.withdraw(800));
		threads[1] = new Thread(() -> account.withdraw(600));
		threads[2] = new Thread(() -> account.withdraw(1000)); // will likely wait
		threads[3] = new Thread(() -> account.withdraw(200));
		threads[4] = new Thread(() -> account.withdraw(900));
		threads[5] = new Thread(() -> account.withdraw(700));
		threads[6] = new Thread(() -> account.withdraw(400));
		threads[7] = new Thread(() -> account.withdraw(1100)); // may timeout

		threads[8] = new Thread(() -> {
			try { Thread.sleep(1000); } catch (Exception e) {}
			account.deposit(500);
		});
		threads[9] = new Thread(() -> {
			try { Thread.sleep(1500); } catch (Exception e) {}
			account.deposit(700);
		});
		threads[10] = new Thread(() -> {
			try { Thread.sleep(500); } catch (Exception e) {}
			account.deposit(300);
		});
		threads[11] = new Thread(() -> account.deposit(400));
		threads[12] = new Thread(() -> {
			try { Thread.sleep(800); } catch (Exception e) {}
			account.deposit(1000);
		});
		threads[13] = new Thread(() -> {
			try { Thread.sleep(1200); } catch (Exception e) {}
			account.deposit(200);
		});
		threads[14] = new Thread(() -> {
			try { Thread.sleep(600); } catch (Exception e) {}
			account.deposit(600);
		});
		threads[15] = new Thread(() -> {
			try { Thread.sleep(900); } catch (Exception e) {}
			account.deposit(450);
		});

		for (int i = 0; i < threads.length; i++) {
			threads[i].setName("T" + (i + 1));
			threads[i].start();
		}
	}
}

