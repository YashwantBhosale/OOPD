// Stratergy design pattern in java
// Program ref: digital ocean 
// Problem: Multiple payment systems
import java.util.*;

interface PaymentStratergy {
	void pay(int amount);
}

class CreditCardStratergy implements PaymentStratergy {
	private String name;
	private String cardNo;
	private String cvv;

	CreditCardStratergy(String n, String CardNo, String cvv) {
		this.name = n;
		this.cardNo = CardNo;
		this.cvv = cvv;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Rs." + amount + " paid with credit card by " + name);
	}
}

class UPIStratergy implements PaymentStratergy {
	private String name;
	private String upiId;

	UPIStratergy (String name, String id) {
		this.name = name;
		this.upiId = id;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Rs." + amount + " paid with UPI by " + this.name);
	}
}

class PaypalStratergy implements PaymentStratergy {
	private String name;	
	private String email;
	private String password;

	PaypalStratergy(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	@Override
	public void pay(int amount) {
		System.out.println("Rs." + amount + " paid with Paypal by " + name);
	}
}

class Item {
	private String id;
	private int price;

	Item (String id, int price) {
		this.id = id;
		this.price = price;
	}

	public String getId() {
		return this.id;
	}

	public int getPrice() {
		return this.price;
	}
}

class ShoppingCart {
	ArrayList<Item> items;

	ShoppingCart() {
		this.items = new ArrayList<>();	
	}

	public void addItem(Item item) {
		items.add(item);	
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public int calculateTotal() {
		int total = 0;
		for (Item item: items) {
			total += item.getPrice();
		}
		return total;
	}

	public void pay(PaymentStratergy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);	
	}
}

public class Stratergy{
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		Item item1 = new Item("1234", 10);
		Item item2 = new Item("5798", 20);
		Item item3 = new Item("5718", 50);
		Item item4 = new Item("5788", 60);
		Item item5 = new Item("5898", 70);

		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		cart.addItem(item4);
		cart.addItem(item5);

		cart.pay(new CreditCardStratergy("Yash", "1234125", "598"));
		cart.pay(new UPIStratergy("Yash", "yash@oksbi"));
		cart.pay(new PaypalStratergy("Yash", "yashbhosale@gmail.com", "yash123"));
	}
}
