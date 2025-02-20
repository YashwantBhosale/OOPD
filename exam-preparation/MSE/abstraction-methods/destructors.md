## Destructor in Java
- In general, **destructors** are used to release resources before an object is destroyed.
- In Java, **destructors** are not available.
- Java has **garbage collection** mechanism that automatically releases memory.
- **Garbage collection** is the process of automatically freeing memory of objects that are no longer in use.

## Garbage Collection in Java
- Java Garbage Collector removes objects that are no longer referenced, freeing up memory.
- JVM automatically calls the garbage collector when needed

- As programmers, we can request the garbage collector to run using `System.gc()`
- there is also `finalize()` method that is called by the garbage collector before an object is destroyed. It is deprecated in Java 9.
 - It is not guaranteed to run immediately
 - It can delay garbage collection.
 - It also has performance overhead.
- `System.gc()` requests the garbage collector to run, but it is not guaranteed to run immediately.
- JVM decides when to run the garbage collector.

## Example
```java
public class Main{
    public static void main(String[] args) {
        String name = "John";
        name = null;

        // request garbage collector to run
        System.gc();
        System.out.println("Garbage collector called");
    }
}
```