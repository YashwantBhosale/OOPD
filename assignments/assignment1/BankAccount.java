/*
Define a class to represent a bank account. Include the following members: 1. Name of Depositor, 2. Account Number
3. Type of account, 4. Balance amount in the account.
Member functions are:
1. To assign initial values
2. To deposit an amount
3. To withdraw an amount after checking the balance
4. To display name and balance.
Write a main program to test the program.
 */
import java.util.Scanner;

public class BankAccount {
    private final String name, type;
    private final int acNo;
    private float balance;

    BankAccount(String name, int acNo, String type) {
        this.name = name;
        this.acNo = acNo;
        this.type = type;
        this.balance = 0;
    }

    public void deposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        if(amount > balance) {
            System.err.println("Insufficient Bank Balance! You may only withdraw Rs." + balance + " or lesser");
            return;
        }
        balance -= amount;
    }

    public void details() {
        System.out.println("=========================================");
        System.out.println("Name: " + name);
        System.out.println("Account No.: " + acNo);
        System.out.println("Type: " +  type);
        System.out.println("Balance: " + balance);
        System.out.println("=========================================");
    }

    private void menu() {
        System.out.println("Choose action: ");
        System.out.println("1. View Details");
        System.out.println("2. Deposit an amount");
        System.out.println("3. Withdraw an amount");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Yashwant Bhosale", 612303039, "Savings");
        Scanner reader = new Scanner(System.in);

        myAccount.details();

        System.out.print("\nEnter amount to be deposited: ");
        float amount = reader.nextFloat();
        myAccount.deposit(amount);

        myAccount.details();

        System.out.print("\nEnter amount to be withdrawn: ");
        amount = reader.nextFloat();
        myAccount.withdraw(amount);

        myAccount.details();
        /*
        while(true) {
            myAccount.menu();
            int option = reader.nextInt();
            if(option == 4) break;
            switch(option) {
                case 1: {
                    myAccount.details();
                    break;
                }
                case 2: {
                    System.out.print("Enter amount to be deposited: ");
                    float amount = reader.nextFloat();
                    myAccount.deposit(amount);
                    break;
                }
                case 3: {
                    System.out.print("Enter amount to be withdrawn: ");
                    float amount = reader.nextFloat();
                    myAccount.withdraw(amount);
                    break;
                }
                default: {
                    break;
                }
            }
        }
        */

    }

}