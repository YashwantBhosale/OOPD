## Vectors in Java
- **Dynamic Array** that can grow or shrink in size.
- implements **List interface.**
- **Synchronized** i.e. thread-safe.
- **Maintains insertion order.**: Elements are inserted in the order they are added.
- **Duplicates are allowed.**
- implements **RandomAccess** interface, i.e supports indexed element access.

### Creating a vector
1. import the Vector class.
```java
import java.util.Vector;
```
2. Create a vector object.
```java
Vector<Integer> v = new Vector<Integer>();
```
3. we can also specify the initial capacity of the vector.
```java
Vector<Integer> v = new Vector<Integer>(5);
```
4. we can also specify the increment value of the vector.
```java
Vector<Integer> v = new Vector<Integer>(5, 2);
```
here, 5 is the initial capacity and 2 is the increment value, meaning that the vector will increase its size by 2 when it reaches its maximum capacity.

### Methods in Vector
1. `add(element)`: Adds an element to the end of the vector.
2. `add(index, element)`: Adds an element at the specified index.
3. `remove(element)`: Removes the specified element from the vector.
4. `remove(index)`: Removes the element at the specified index.
5. `size()`: Returns the size of the vector.
6. `capacity()`: Returns the current capacity of the vector.
7. `get(index)`: Returns the element at the specified index.
8. `set(index, element)`: Replaces the element at the specified index with the new element.
9. `contains(element)`: Returns true if the vector contains the specified element.
10. `isEmpty()`: Returns true if the vector is empty.
11. `clear()`: Removes all the elements from the vector.

### Example
```java
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>(5, 2);
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);
        System.out.println("Size: " + v.size());
        System.out.println("Capacity: " + v.capacity());
        v.add(6);
        System.out.println("Size: " + v.size());
        System.out.println("Capacity: " + v.capacity());
        v.remove(2);
        System.out.println("Size: " + v.size());
        System.out.println("Capacity: " + v.capacity());
    }
}
```
Output:
```
Size: 5
Capacity: 5
Size: 6
Capacity: 7
Size: 5
Capacity: 7
```
In the above example, we created a vector with an initial capacity of 5 and an increment value of 2. We added 5 elements to the vector, and when we tried to add the 6th element, the vector increased its size by 2. We then removed an element from the vector, and the size remained the same, but the capacity remained the same.

### Differences between ArrayList and Vector
| Feature | ArrayList | Vector |
| ------- | --------- | ------ |
| Thread-safe | Not thread-safe | Thread-safe |
| Performance | Faster | Slower |
| Synchronization | Not synchronized | Synchronized |
| Growth | Increases by 50% | Increases by 100% |
| use cases | When thread safety is not required | When thread safety is required |