/*
 * Simulate a bank in a program and program should throw insufficient bank balance exception on withdrawal if obv the balance is insufficient.
 */

class InsufficientBalance extends Exception{
	InsufficientBalance(String m) {
		super(m);
	}	
}

class BankAccount {
	private int balance;
	private String name;
	
	BankAccount(String name) {
		this.name = name;
		this.balance = 100;
	}

	public void deposit(int amount) {
		this.balance += amount;
		System.out.println(name + " deposited Rs." + amount);
	}

	/*
	 * So here i had two options
	 * 1. i could have handled the exception in the body where i am throwing it
	 * 2. or i could have passed that responsivility to the calling function (which in this case is main)
	 * so now main has to handle the InsufficientBalance Exception, Note that we are extending Exception Class so this is a checked exception and compiler will force you to handle this exception.
	 * */
	public void withdraw(int amount) throws InsufficientBalance{
		if(amount < this.balance) {
			throw new InsufficientBalance("You are broke my guy! get some dough!");
		}
		this.balance -= amount;
		System.out.println(name + " withdrew Rs." + amount);
	}

	public int getBalance() {
		return this.balance;
	}
}

public class Program3{
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alhad");

        try {
            System.out.println("Current Balance: Rs." + account.getBalance());
            
            account.deposit(200);
            System.out.println("New Balance after deposit: Rs." + account.getBalance());
            
            account.withdraw(150);
            System.out.println("New Balance after withdrawal: Rs." + account.getBalance());

            account.withdraw(200);
        } catch (InsufficientBalance e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}

