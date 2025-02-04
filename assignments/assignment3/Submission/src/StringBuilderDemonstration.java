public class StringBuilderDemonstration {
    public static void main(String[] args) {
        // Constructor with no parameters
        StringBuilder builder = new StringBuilder();
        System.out.println("Builder 1: " + builder);

        // Parameterized constructor specifying size
        StringBuilder builder2 = new StringBuilder(10);
        System.out.println("Builder 2: " + builder2);

        // Parameterized constructor specifying initial value of string
        StringBuilder builder3 = new StringBuilder("Yashwant");
        System.out.println("Builder 3: " + builder3);

        // 1. append
        builder.append("Hello");
        builder.append(" ");
        builder.append("Yash!");
        System.out.println("Builder 1 after append: " + builder);

        // 2. length
        System.out.println("Length: " + builder.length());

        // 3. capacity
        System.out.println("Capacity of builder 1: " + builder.capacity());
        System.out.println("Capacity of builder 2: " + builder2.capacity());
        System.out.println("Capacity of builder 3: " + builder3.capacity());

        // 4. delete
        builder.delete(4, 6);
        System.out.println("Builder after delete(4, 6): " + builder);
		// dletes characters between specified indexes (endIndex exclusive)

        // 5. reverse
        System.out.println("Original: " + builder);
        System.out.println("Reversed: " + builder.reverse());

        // 6. insert
        builder.insert(0, "Prefix ");
        System.out.println("Builder after insert(0, 'Prefix '): " + builder);
		// inserts string at specified index

        // 7. replace
        builder.replace(7, 11, "Yashwant");
        System.out.println("Builder after replace(7, 11, 'Yashwant'): " + builder);
		// replaces characters between specified indexes with specified string

        // 8. setCharAt
        builder.setCharAt(0, 'X');
        System.out.println("Builder after setCharAt(0, 'X'): " + builder);
		// sets character at specified index

        // 9. ensureCapacity
        builder.ensureCapacity(50);
        System.out.println("Builder capacity after ensureCapacity(50): " + builder.capacity());
		// increases capacity of builder to specified value
    }
}
