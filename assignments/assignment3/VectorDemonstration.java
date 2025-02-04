import java.util.Vector;

public class VectorDemonstration {
    public static void main(String[] args) {
        // Creating a Vector of Numbers
        Vector<Integer> vector = new Vector<>();

        // 1. add(E e)
        vector.add(10);
        vector.add(20);
        vector.add(30);
        System.out.println("Vector: " + vector);

        // 2. add(int index, E e)
        vector.add(1, 15);
        System.out.println("after add(1, 15): " + vector);

        // 3. remove(Object o)
        vector.remove(Integer.valueOf(20));
        System.out.println("after remove(20): " + vector);
        // remove(Object o) removes the first occurrence of the specified element from the vector
        // this is different from remove(int index) which removes the element at the specified index
        // here we are explicityly typecasting 20 to Integer because remove(Object o) expects an object

        // 4. remove(int index)
        vector.remove(2);
        System.out.println("after remove(2): " + vector);

        // 5. size()
        System.out.println("size: " + vector.size());

        // 6. get(int index)
        System.out.println("element at index 1: " + vector.get(1));

        // 7. set(int index, E e)
        vector.set(1, 25);
        System.out.println("after set(1, 25): " + vector);

        // 8. isEmpty()
        System.out.println("is empty? " + vector.isEmpty());

        // 9. contains(Object o)
        System.out.println("contains 10? " + vector.contains(10));

        // 10. clear()
        vector.clear();
        System.out.println("after clear(): " + vector);
        System.out.println("is empty now? " + vector.isEmpty());
    }
}
