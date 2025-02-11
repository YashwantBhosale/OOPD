import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("\nChoose action:");
        System.out.println("1. View Bank Account Info");
        System.out.println("2. Deposit Money (via any Payment Method)");
        System.out.println("3. Pay with Debit Card");
        System.out.println("4. Refund via Debit Card");
        System.out.println("5. Pay with Credit Card");
        System.out.println("6. Refund via Credit Card");
        System.out.println("7. View Credit Card Bill");
        System.err.println("8. Pay Credit Card Bill");
        System.out.println("9. Pay with UPI");
        System.out.println("10. Refund via UPI");
        System.out.println("11. Pay with Digital Wallet");
        System.out.println("12. Refund via Digital Wallet");
        System.out.println("13. Exit");
		System.out.println("=========================================\n");
        System.out.print(" > ");

    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        User user = new User("Yashwant", 1234);

        System.out.print("Enter Username: ");
        String username = reader.next();
        System.out.print("Enter Password: ");
        int password = reader.nextInt();

        if (!user.login(username, password)) {
            System.err.println("Login Failed!");
            return;
        }

        System.out.println("Login Successful!");

        Bank myBank = new Bank("Yashwant", 1234, "Saving");

        DebitCard myDebitCard = new DebitCard("Yashwant", myBank, 12345, 123);
        CreditCard myCreditCard = new CreditCard("Yashwant", myBank, 54321, 321);
        UPI myUPI = new UPI("Yashwant", myBank, "yashwant@upi");
        DigitalWallet myDigitalWallet = new DigitalWallet("Yashwant", myBank, "PayTM");

        while (true) {
			menu();

            int choice = reader.nextInt();
            float amount;

            switch (choice) {
                case 1:
                    myBank.getAccountInfo();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    amount = reader.nextFloat();
                    // we can use any payment method here as every payment method references the same bank instance.
                    myDebitCard.deposit(amount);
                    break;
                case 3:
                    System.out.print("Enter amount to pay via Debit Card: ");
                    amount = reader.nextFloat();
                    myDebitCard.makePayment(amount);
                    break;
                case 4:
                    System.out.print("Enter refund amount to Debit Card: ");
                    amount = reader.nextFloat();
                    myDebitCard.refund(amount);
                    break;
                case 5:
                    System.out.print("Enter amount to pay via Credit Card: ");
                    amount = reader.nextFloat();
                    myCreditCard.makePayment(amount);
                    break;
                case 6:
                    System.out.print("Enter refund amount to Credit Card: ");
                    amount = reader.nextFloat();
                    myCreditCard.refund(amount);
                    break;
                case 7:
                    System.out.println("Credit Card Bill: " + myCreditCard.getCreditCardBill());
                    break;
                case 8:
                    myCreditCard.payCreditCardBill();
                    break;
                case 9:
                    System.out.print("Enter amount to pay via UPI: ");
                    amount = reader.nextFloat();
                    myUPI.makePayment(amount);
                    break;
                case 10:
                    System.out.print("Enter refund amount to UPI: ");
                    amount = reader.nextFloat();
                    myUPI.refund(amount);
                    break;
                case 11:
                    System.out.print("Enter amount to pay via Digital Wallet: ");
                    amount = reader.nextFloat();
                    myDigitalWallet.makePayment(amount);
                    break;
                case 12:
                    System.out.print("Enter refund amount to Digital Wallet: ");
                    amount = reader.nextFloat();
                    myDigitalWallet.refund(amount);
                    break;
                case 13:
                    return;
                default:
                    System.err.println("Invalid choice!");
                    break;
            }
        }
    }
}
