public class DigitalWallet extends PaymentMethod {
    private String walletProvider;

    public DigitalWallet(String holderName, Bank bank, String walletProvider) {
        super(holderName, bank);
        this.walletProvider = walletProvider;
    }

    @Override
    public void makePayment(float amount) {
        if (amount > bank.balance()) {
            System.err.println("Digital Wallet Payment: Insufficient bank balance!");
            return;
        }
        bank.withdraw(amount);
        System.out.println("Paid Rs. " + amount + " using Digital Wallet " + walletProvider);
    }

    @Override
    public void refund(float amount) {
        bank.deposit(amount);
        System.out.println("Refunded Rs. " + amount + " to Digital Wallet " + walletProvider);
    }
}
