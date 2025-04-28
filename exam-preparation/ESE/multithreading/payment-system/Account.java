import java.util.Random;

public class Account {
	private final int accountId;
	private string accountHolderName;
	private int balance; // int for simplicity, we may use double or float

	Account(String name) {
		this.accountHolderName = name;
		this.balance  = 100; // 100 rs bonus for signing up in our bank :)

		this.accountId = generateRandomId();
	}	
	
	public synchronized void deposit(int amount) {
		this.balance += amount;
	}

	// here, the withdraw could fail if there is insufficient balance
	// so withdraw method will return a boolean indicating whether the
	// withdraw was successful
	public synchronized boolean withdraw(int amount) {
		if (this.balance < amount) {
			System.err.println("Insufficient Bank balance! You are broke!");
			return false;
		}
		this.balance -= amount;
		return true;
	}

	public synchronized int getBalance() {
		return this.balance;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public static int generateRandomId() {
		Random random = new Random();
		return 10000 + random.nextInt(9000);
		// random.nextInt(int n) returns random number between 0 and 9000 in this case. if no argument is given it generates any random number even negative.
	}
}
