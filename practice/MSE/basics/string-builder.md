## StringBuilder Class in Java
- `StringBuilder` is a class in Java used to create **mutable (modifiable) string objects**, similar to `StringBuffer`.
- Unlike `String`, which is **immutable**, `StringBuilder` allows modification of strings **without creating new objects**, making it more efficient for frequent string manipulations.
- `StringBuilder` is **not synchronized**, meaning it is **not thread-safe** but is **faster than StringBuffer** in a **single-threaded environment**.
- It expands dynamically when needed, just like `StringBuffer`, to accommodate growing data.

### Constructors    
- `StringBuilder()`: Creates an empty string builder with an **initial capacity of 16 characters**.
- `StringBuilder(int capacity)`: Creates an empty string builder with the specified initial capacity.
- `StringBuilder(String str)`: Creates a string builder with the specified string.

### Methods
- `append(String str)`: Appends the string representation of the argument to the `StringBuilder`.
- `insert(int offset, String str)`: Inserts the given string at the specified index.
- `replace(int start, int end, String str)`: Replaces characters from `start` to `end` index with the specified string.
- `delete(int start, int end)`: Deletes characters from `start` to `end` index.
- `reverse()`: Reverses the characters in the `StringBuilder`.
- `length()`: Returns the length of the `StringBuilder`.
- `capacity()`: Returns the current capacity of the `StringBuilder`.
- `setCharAt(int index, char ch)`: Sets the character at the specified index.
- `ensureCapacity(int minimumCapacity)`: Ensures the capacity is at least the specified minimum capacity.

##### Example
```java
public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("StringBuilder: " + sb);
        sb.append(" World");
        System.out.println("After appending: " + sb);
        sb.insert(5, " Java");
        System.out.println("After inserting: " + sb);
        sb.replace(5, 10, " C++");
        System.out.println("After replacing: " + sb);
        sb.delete(5, 9);
        System.out.println("After deleting: " + sb);
        sb.reverse();
        System.out.println("After reversing: " + sb);
    }
}
```
##### Output:
```
StringBuilder: Hello
After appending: Hello World
After inserting: Hello Java World
After replacing: Hello C++ World
After deleting: Hello World
After reversing: dlroW olleH
```

### When to Use StringBuilder
- When frequent **modification of strings** is required and thread safety is **not a concern**.
- When **performance is critical**, as `StringBuilder` is faster than `StringBuffer`.
- When working in a **single-threaded environment** where synchronization is unnecessary.