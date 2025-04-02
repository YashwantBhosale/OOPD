package queuepackage;

import java.util.*;

public class Queue<T>{
    private Vector<T> queue;

    public Queue() {
        queue = new Vector<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getSize() {
        return queue.size();
    }

    public void enqueue(T element) {
        queue.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            System.err.println("Queue is Empty!");
            return null;
        }
        return queue.remove(0);
    }

    public T front() {
        if (isEmpty()) {
            System.err.println("Queue is Empty!");
            return null;
        }
        return queue.firstElement();
    }

    public void display() {
        System.out.print("Queue: [ ");
        for (int i = 0; i < queue.size(); i++) {
            System.out.print(queue.get(i) + ",");
        }
        System.out.print("\b ]");
        System.out.println();
    }
}
