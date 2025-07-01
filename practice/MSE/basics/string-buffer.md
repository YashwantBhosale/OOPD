## String Buffer Class in Java
- String Buffer is a class in Java that is used to create mutable (modifiable) string objects.
- Strings are immutable in Java, i.e., once a string object is created, it cannot be changed. If we try to change the value of the string object, a new object is created and the reference is changed to the new object.
- So, if a program requires a lot of string manipulations, it is not recommended to use the string class. Instead, the string buffer class should be used.
- StringBuffer is **syncronized** i.e., it is thread safe. It means that two threads cannot call the methods of StringBuffer simultaneously. It is safe because it will not be corrupted by multiple threads.
- It is **slower than StringBuilder** because of the thread safety, but **faster than String class** when performing multiple modifications.
- StringBuffer expads dynamically when needed.

### Constructors    
- `StringBuffer()`: Creates an empty string buffer with the initial capacity of **16 characters**.
- `StringBuffer(int capacity)`: Creates an empty string buffer with the specified capacity as length.
- `StringBuffer(String str)`: Creates a string buffer with the specified string.

### Methods
- `append(String str)`: Appends the string representation of the argument to the string buffer.
- `insert(int offset, String str)`: Inserts the string representation of the argument into the string buffer at the specified offset.
- `replace(int start, int end, String str)`: Replaces the characters in the string buffer from the start index to the end index with the specified string.
- `delete(int start, int end)`: Deletes the characters in the string buffer from the start index to the end index.
- `reverse()`: Reverses the characters in the string buffer.
- `length()`: Returns the length of the string buffer.
- `capacity()`: Returns the current capacity of the string buffer.
- `setCharAt(int index, char ch)`: Sets the character at the specified index to the specified character.
- `ensureCapacity(int minimumCapacity)`: Ensures that the capacity of the string buffer is at least equal to the specified minimum capacity.

##### Example
```java
public class Main {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("String buffer: " + sb);
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
Output:
```
String buffer: Hello
After appending: Hello World
After inserting: Hello Java World
After replacing: Hello C++ World
After deleting: Hello World
After reversing: dlroW olleH
```

### When to use StringBuffer
- When the string is to be modified frequently, StringBuffer should be used.
- when you are working with multiple threads, StringBuffer should be used.
- when performance is a concern and StringBuilder cannot be used.