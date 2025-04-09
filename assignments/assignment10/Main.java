import java.utils.vector;

class Store<T> {
	private Vector<T> items;
	private String name;

	Store(String name) {
		this.name = name;
	}

	void addItem(T item) {
		this.items.add(item);
	}

	void removeItem(T item) {
		this.items.remove(item);
	}

	void getItem(int index) {
		return this.items.get(index);
	}
}

class Book {
	private String name, author;


}
