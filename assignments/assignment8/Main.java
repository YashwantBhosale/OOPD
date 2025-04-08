import java.util.*;

import queuepackage.Queue;
import stackpackage.Stack;

class Utils {
    // generic method to print an array
    public static <T> void print(T[] arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // generic method to swap two elements
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}


public class Main {

    public static void main(String[] args) {
        // 1. ArrayList
        System.out.println("ArrayList:");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList: " + arrayList);
        arrayList.remove(1);  // here 1 is index and NOT element
        System.out.println("After removal: " + arrayList);
        System.out.println("Element at index 1: " + arrayList.get(1));
        System.out.println();

        // 2. LinkedList
        System.out.println("LinkedList:");
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("yash");
        linkedList.add("mehmood");
        linkedList.add("aryan");
        System.out.println("LinkedList: " + linkedList);
        
        linkedList.remove(1);  // here 1 is index and NOT element
        linkedList.add(1, "alhad"); // adding at index 1
        linkedList.remove("mehmood"); // removing by value her we can also specify index

        System.out.println("After modifications: " + linkedList);
        System.out.println("First Element: " + linkedList.getFirst());
        System.out.println();


        // 3. HashSet
        System.out.println("HashSet:");
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("yash");
        hashSet.add("mehmood");
        hashSet.add("alhad");
        hashSet.add("arya");
        hashSet.add("yash"); // duplicate element ~ you cannot add duplicate elements in a set
        System.out.println("HashSet: " + hashSet);

        hashSet.remove("arya");
        System.out.println("After removal: " + hashSet);
        System.out.println("Contains 'yash'?: " + hashSet.contains("yash"));
        System.out.println();

        // 4. TreeSet
        System.out.println("TreeSet:");
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        treeSet.add(111);
        treeSet.add(0);
        treeSet.add(69);
        treeSet.add(155);
        treeSet.add(96);

        System.out.println("TreeSet: " + treeSet);
        treeSet.remove(0);
        System.out.println("After removal: " + treeSet);
        System.out.println("Contains 69?: " + treeSet.contains(69));
        System.out.println();
        
        // 5. Stack
        Stack<Integer> intStack = new Stack<Integer>();
        intStack.push(101);
        intStack.push(229);
        intStack.push(369);
        intStack.display();
        System.out.println(intStack.pop() + " was popped");
        System.out.println("top-> " + intStack.peek());
        intStack.display();
        System.out.println();

        Stack<String> stringStack = new Stack<String>();
        stringStack.push("alhad");
        stringStack.push("arya");
        stringStack.push("yash");
        stringStack.display();
        System.out.println(stringStack.pop() + " was popped");
        System.out.println("top ->" + stringStack.peek());
        stringStack.display();
        System.out.println();

        // 6. Queue
        Queue<Integer> intQueue = new Queue<Integer>();
        intQueue.enqueue(101);
        intQueue.enqueue(229);
        intQueue.enqueue(369);
        intQueue.display();
        System.out.println(intQueue.dequeue() + "was dequeued");
        System.out.println("top ->" + intQueue.front());
        intQueue.display();
        System.out.println();

        Queue<String> stringQueue = new Queue<String>();
        stringQueue.enqueue("suswan");
        stringQueue.enqueue("hardik");
        stringQueue.enqueue("aryan");
        stringQueue.display();
        System.out.println(stringQueue.dequeue() + " gela baher");
        System.out.println("to0 ->" + stringQueue.front());
        stringQueue.display();
        System.out.println();

        // Generic Method Examples
        System.out.println("Generic Method Examples:");
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"alhad", "suswan", "aryan"};

        System.out.println("Integer Array:");
        Utils.print(intArray);

        System.out.println("String Array:");
        Utils.print(strArray);

        System.out.println("Swapping elements in Integer Array:");
        Utils.swap(intArray, 0, 4);
        Utils.print(intArray);

        System.out.println("Swapping elements in String Array:");
        Utils.swap(strArray, 0, 2);
        Utils.print(strArray);
    }
}
