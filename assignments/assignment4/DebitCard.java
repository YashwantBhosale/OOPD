public class DebitCard extends PaymentMethod {
	private int cardNumber, cvv;

	public DebitCard(String holderName, Bank bank, int cardNumber, int cvv) {
        super(holderName, bank);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

	@Override
	public void makePayment(float amount) {
		if(this.bank.balance() > amount) {
			this.bank.withdraw(amount);
			System.out.println("Payment Successful!: " + amount);
		} else {
			System.err.println("Insufficient Balance!");
		}

	}

	@Override
	public void refund(float amount) {
		this.deposit(amount);
		System.out.println("Refund through Debit Card Successful!: " + amount);
	}
}