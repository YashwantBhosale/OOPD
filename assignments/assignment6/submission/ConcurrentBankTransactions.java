
class BankAccount {
    private double balance;
    private final String name;
    private final String accType;

    BankAccount(String name, String accType) {
        this.name = name;
        this.accType = accType;
        this.balance = 1000; // default initial balance
    }

    public synchronized void withdraw(double amount) {
        if (this.balance < amount) {
            System.err.println(name + "Insufficient Balance! You may withdraw " + this.balance + " or less");
            return;
        }
        this.balance -= amount;
        System.out.println(name + " withdrawn " + amount + " Rs. ");

        System.out.println(this.name + " Balance after withdraw: " + this.balance);
        // this.getDetails();
    }

    public synchronized void deposit(double amount) {
        this.balance += amount;
        System.out.println(name + " deposited " + amount + " Rs. ");

        System.out.println(this.name + " Balance after deposit: " + this.balance);
        // this.getDetails();
    }

    public synchronized void getDetails() {
        System.out.println(name + " - Account Type: " + accType + " : Balance: " + balance);
    }
}

class Action extends Thread {

    private final String action;
    private final BankAccount account;
    private final double amount;

    Action(String action, double amount, BankAccount account) {
        this.action = action;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (action.equals("DEPOSIT")) {
            account.deposit(amount);
        } else if (action.equals("WITHDRAW")) {
            account.withdraw(amount);
        } else {
            account.getDetails();
        }
    }
}

public class ConcurrentBankTransactions {

    public static void main(String[] args) {
        BankAccount yash = new BankAccount("Yash", "Savings");
        BankAccount alhad = new BankAccount("Alhad", "Savings");
        BankAccount suswan = new BankAccount("Suswan", "Savings");

        Action t1 = new Action("DEPOSIT", 500, yash);
        Action t2 = new Action("WITHDRAW", 300, yash);
        Action t3 = new Action("DEPOSIT", 700, alhad);
        Action t4 = new Action("WITHDRAW", 200, alhad);
        Action t5 = new Action("DEPOSIT", 900, suswan);
        Action t6 = new Action("WITHDRAW", 500, suswan);
        Action t7 = new Action("DETAILS", 0, yash);
        Action t8 = new Action("DETAILS", 0, alhad);
        Action t9 = new Action("DETAILS", 0, suswan);

        // if we want to have transactions related to particular account to run parallely we may create array of actions and start them in a loop
        

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

/*
    Output:
    Suswan deposited 900.0 Rs. 
    Alhad deposited 700.0 Rs. 
    Yash deposited 500.0 Rs. 
    Suswan Balance after deposit: 1900.0
    Yash Balance after deposit: 1500.0
    Alhad Balance after deposit: 1700.0
    Suswan - Account Type: Savings : Balance: 1900.0
    Alhad - Account Type: Savings : Balance: 1700.0
    Suswan withdrawn 500.0 Rs. 
    Suswan Balance after withdraw: 1400.0
    Alhad withdrawn 200.0 Rs. 
    Alhad Balance after withdraw: 1500.0
    Yash - Account Type: Savings : Balance: 1500.0
    Yash withdrawn 300.0 Rs. 
    Yash Balance after withdraw: 1200.0

    one important thing to note here is that this output will NOT be the same every time you run the program.
    this is because even though we start the threads sequentially, they run concurrently and the order of execution is not guaranteed because that depends on the OS and the JVM.
    so the output may vary.

    Although, withdraw and deposit operations are "synchronized" meaning only one thread can access the method at a time. both of them will not be modifying the balance at the same time.
 */

/*
    1. we start with creating 3 bank accounts for Yash, Alhad, and Suswan.
    2. then we create 9 threads, 3 for each account. 1 for deposit, 1 for withdraw, and 1 for getting details.
    3. we start all the threads.
    4. the threads run concurrently and the output is printed.
    5. the output may vary because of the concurrent execution of threads.
 */
