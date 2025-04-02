package stackpackage;

import java.util.*;

public class Stack<T>{
    private Vector<T> stack;

    public Stack() {
        stack = new Vector<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            System.err.println("Stack is Empty!");
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            System.err.println("Stack is Empty!");
            return null;
        }
        return stack.lastElement();
    }

    public void display() {
        System.out.print("Stack: [ ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + ",");
        }
        System.out.print("\b ]");
        System.out.println();
    }
}
