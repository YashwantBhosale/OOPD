public abstract class PaymentMethod implements PaymentInterface{
    protected Bank bank;
    protected String name;

    PaymentMethod(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    public void deposit(float amount) {
        this.bank.deposit(amount);
    }
}
