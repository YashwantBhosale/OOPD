class Pair <K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void print() {
		System.out.println(this.key + " : " + this.value);
	} 
}

public class GenericPair {
	public static void main(String[] args) {
		Pair<String, Integer> p1 =  new Pair<>("Yashwant", 303039);
		Pair<Double, Double> p2 = new Pair<>(17.87, 19.69);
		Pair<String, Boolean> p3 = new Pair<>("isValid", true);

		p1.print();
		p2.print();
		p3.print();
	}
}
