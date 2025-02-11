/*
 * Develop an Online Payment System where users can make payments using different payment methods such as Credit Card, Debit Card, UPI, and Digital Wallets.
*/
public class Bank {
	private float balance;
	private String name;
	private int accNo;
	private String type;


	Bank(String name, int accNo, String type) {
		this.name = name;
		this.accNo = accNo;
		this.balance = 0;
		this.type = type;
	}

	public void deposit(float amount) {
		this.balance += amount;
		System.out.println("Deposited: " + amount);
	}
	

	public void withdraw(float amount) {
		if(amount > this.balance) {
			System.err.println("Insufficient balance!");
			return;
		}

		this.balance -= amount;
		System.out.println("Withdrawn: " + amount);
	}

	public float balance() {
		return this.balance;
	}

	public void getAccountInfo() {
        System.out.println("=========================================");
        System.out.println("Name: " + this.name);
        System.out.println("Account No.: " + this.accNo);
        System.out.println("Type: " + this.type);
        System.out.println("Balance: " + this.balance);
        System.out.println("=========================================");
    }
}
