public class UPI extends PaymentMethod{
	private String upiId;

	public UPI(String holderName, Bank bank, String upiId) {
        super(holderName, bank);
        this.upiId = upiId;
    }

	@Override
	public void makePayment(float amount) {
		if(this.bank.balance() > amount) {
			this.bank.withdraw(amount);
			System.out.println("Paid Rs. " + amount + " using UPI (" + upiId + ").");
		} else {
			System.err.println("Insufficient Balance!");
		}
	}

	@Override
	public void refund(float amount) {
		this.deposit(amount);
		System.out.println("Refunded Rs. " + amount + " to UPI (" + upiId + ").");
	}
}