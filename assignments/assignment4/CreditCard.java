public class CreditCard extends PaymentMethod {
	private int cardNumber, cvv, creditPoints;
	final int creditPointsLimit = 1000;	

	public CreditCard(String holderName, Bank bank, int cardNumber, int cvv) {
        super(holderName, bank);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditPoints = 0;
    }

	@Override
	public void makePayment(float amount) {
		if(creditPoints >= creditPointsLimit) {
			System.err.println("Credit points limit exceeded!");
			return;
		}

		creditPoints += amount;
		System.out.println("Paid Rs. " + amount + " using Credit Card. (Credit used: Rs. " + this.creditPoints + ")");
	}

	@Override
	public void refund(float amount) {
		if(creditPoints < amount) {
			System.err.println("Insufficient Credit Points!");
			return;
		}

		creditPoints -= amount;
		System.out.println("Refund through Credit Card Successful!: " + amount);

		/*
		 * Refund works in the following way:
		 * 1. If the credit points are less than the amount to be refunded, then the refund is not possible.
		 * 2. we are basically refunding the amount from the credit points.
		 * 
		 * credit points are essentially "a debt" that the user has to pay to the bank. we are reducing that
		 * as "refund".
		 */
	}

	public void payCreditCardBill() {
		if(creditPoints > this.bank.balance()) {
			System.err.println("Insufficient balance to pay Credit Card bill!");
			System.out.println("Penalty of Rs. 100 will be charged.");
			this.creditPoints += 100;
			System.out.println("Credit Bill to be paid: Rs. " + (this.creditPoints));
			return;
		}

		this.bank.withdraw(creditPoints);
		System.out.println("Credit Card bill paid successfully!");
		this.creditPoints = 0;
	}

	public float getCreditCardBill() {
		return this.creditPoints;
	}
}