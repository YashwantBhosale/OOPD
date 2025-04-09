import java.util.Vector;

/*
We want to:
•Store multiple types of products (Books, Electronics, Clothing, Food, Furniture, and Toys).
•Use a generic function to display product details.
•Use a generic class to store and retrieve different product types.

Implementing Generics in Java using 6 classes:
•A generic class (Store<T>) to store different types of objects.
•  Six different product classes (Book, Electronic, Clothing, Food, Furniture, and Toy).
•    A generic function to display details of any object.
*/

class Store<T> {
	private Vector<T> items;
	private String name;

	Store(String name) {
		this.name = name;
		this.items = new Vector<T>();
	}

	void addItem(T item) {
		this.items.add(item);
	}

	void removeItem(T item) {
		this.items.remove(item);
	}

	T getItem(int index) {
		return this.items.get(index);
	}

	int size() {
		return this.items.size();
	}

	String getName() {
		return this.name;
	}
}

abstract class Item {
	abstract String details();
}

class Book extends Item {
	private String name, author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public String details() {
		return "Book: " + this.name + "by " + this.author;
	}
}

class Electronic extends Item {
	private String name, brand;

	public Electronic(String name, String brand) {
		this.name = name;
		this.brand = brand;
	}

	public String details() {
		return "Electronic: " + this.name + ", Brand: " + this.brand;
	}
}

class Clothing extends Item {
	private String name, size;

	public Clothing(String name, String size) {
		this.name = name;
		this.size = size;
	}

	public String details() {
		return "Clothing: " + this.name + ", Size: " + this.size;
	}
}

class Food extends Item {
	private String name, expiryDate;

	public Food(String name, String expiryDate) {
		this.name = name;
		this.expiryDate = expiryDate;
	}

	public String details() {
		return "Food: " + this.name + ", Expiry Date: " + this.expiryDate;
	}
}

class Furniture extends Item {
	private String name, material;

	public Furniture(String name, String material) {
		this.name = name;
		this.material = material;
	}

	public String details() {
		return "Furniture: " + this.name + ", Material: " + this.material;
	}
}

public class Main {
	public static <T extends Item> void displayDetails(Store<T> store) {
		System.out.println("Store: " + store.getName());
		for (int i = 0; i < store.size(); i++) {
			System.out.println(store.getItem(i).details());
		}		
		System.out.println();
	}

	public static void main(String[] args) {
		Book books[] = new Book[3];
		books[0] = new Book("Book1", "Author1");
		books[1] = new Book("Book2", "Author2");
		books[2] = new Book("Book3", "Author3");

		Electronic electronics[] = new Electronic[3];
		electronics[0] = new Electronic("Electronic1", "Brand1");
		electronics[1] = new Electronic("Electronic2", "Brand2");
		electronics[2] = new Electronic("Electronic3", "Brand3");

		Clothing clothing[] = new Clothing[3];
		clothing[0] = new Clothing("Clothing1", "Size1");
		clothing[1] = new Clothing("Clothing2", "Size2");
		clothing[2] = new Clothing("Clothing3", "Size3");
		
		Store<Book> bookStore = new Store<Book>("Book Store");
		for (Book book : books) {
			bookStore.addItem(book);
		}

		Store<Electronic> electronicStore = new Store<Electronic>("Electronic Store");
		for (Electronic electronic : electronics) {
			electronicStore.addItem(electronic);
		}

		Store<Clothing> clothingStore = new Store<Clothing>("Clothing Store");
		for (Clothing cloth : clothing) {
			clothingStore.addItem(cloth);
		}

		displayDetails(bookStore);
		displayDetails(electronicStore);
		displayDetails(clothingStore);
	}
}
