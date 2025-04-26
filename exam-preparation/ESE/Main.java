class Main {
	// Generic method
	public static <T extends Comparable<T>> T getMax(T a, T b) {
		return (a.compareTo(b) > 0) ? a : b;
	}

	public static void main(String[] args) {
		// Using the generic method
		int maxInt = getMax(10, 20);
		double maxDouble = getMax(10.5, 20.5);
		String maxString = getMax("apple", "banana");

		System.out.println("Max Integer: " + maxInt);
		System.out.println("Max Double: " + maxDouble);
		System.out.println("Max String: " + maxString);
	}
}
