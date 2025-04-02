import java.util.Vector;

class Stack<T> {
    private Vector<T> stack;

    public Stack() {
        stack = new Vector<T>();
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

class Queue<T> {
    private Vector<T> queue;

    public Queue() {
        queue = new Vector<T>();
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
            System.err.println("queue is empty!");
            return null;
        }
        return queue.remove(0);
    }

    public T front() {
        if (isEmpty()) {
            System.err.println("queue is empty!");
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

public class Main {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(101);
        intStack.push(229);
        intStack.push(369);
        intStack.display();
        System.out.println(intStack.pop() + " was popped");
        System.out.println("top-> " + intStack.peek());
        intStack.display();

        Stack<String> stringStack = new Stack<String>();
        stringStack.push("alhad");
        stringStack.push("arya");
        stringStack.push("yash");
        stringStack.display();
        System.out.println(stringStack.pop() + " was popped");
        System.out.println("top ->" + stringStack.peek());
        stringStack.display();

        Queue<Integer> intQueue = new Queue<Integer>();
        intQueue.enqueue(101);
        intQueue.enqueue(229);
        intQueue.enqueue(369);
        intQueue.display();
        System.out.println(intQueue.dequeue() + "was dequeued");
        System.out.println("top ->" + intQueue.front());
        intQueue.display();

        Queue<String> stringQueue = new Queue<String>();
        stringQueue.enqueue("suswan");
        stringQueue.enqueue("hardik");
        stringQueue.enqueue("aryan");
        stringQueue.display();
        System.out.println(stringQueue.dequeue() + " gela baher");
        System.out.println("to0 ->" + stringQueue.front());
        stringQueue.display();
    }
}
