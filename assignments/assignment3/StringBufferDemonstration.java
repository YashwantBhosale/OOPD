public class StringBufferDemonstration {
    public static void main(String[] args) {
        // constructor with no parameters
        StringBuffer buffer = new StringBuffer();
        System.out.println(buffer);

        // parametrized constructor specifying size
        StringBuffer buffer2 = new StringBuffer(10);
        System.out.println(buffer2);

        // parametrized constructor specifying initial value of string
        StringBuffer buffer3 = new StringBuffer("Yashwant");
        System.out.println(buffer3);

        // 1. append
        buffer.append("Hello");
        buffer.append(" ");
        buffer.append("Yash!");
        System.out.println("Buffer 1 after append: " + buffer);

        // 2. length
        System.out.println("Length: " + buffer.length());

        // 3. capacity
        System.out.println("Capacity of buffer 1: " + buffer.capacity());
        System.out.println("Capacity of buffer 2: " + buffer2.capacity());
        System.out.println("Capacity of buffer 3: " + buffer3.capacity());

        // 4. delete
        buffer.delete(4, 6);
        System.out.println("Buffer after delete(4, 6): " + buffer);
		// delete characters between specified indexes (endIndex exclusive)

        // 5. reverse
        System.out.println("original: " + buffer);
        System.out.println("reversed: " + buffer.reverse());

        // 6. insert
        buffer.insert(0, "Prefix ");
        System.out.println("Buffer after insert(0, 'Prefix '): " + buffer);
		// insert string at specified index

        // 7. replace
        buffer.replace(7, 11, "Yashwant");
        System.out.println("Buffer after replace(7, 11, 'Yashwant'): " + buffer);
		// replace characters between specified indexes with specified string

        // 8. setCharAt
        buffer.setCharAt(0, 'X');
        System.out.println("Buffer after setCharAt(0, 'X'): " + buffer);
		// set character at specified index

        // 9. ensureCapacity
        buffer.ensureCapacity(50);
        System.out.println("Buffer capacity after ensureCapacity(50): " + buffer.capacity());
		// increase capacity of buffer to specified value
    }
}