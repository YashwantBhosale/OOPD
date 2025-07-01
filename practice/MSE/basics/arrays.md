## Arrays in Java
- data structure that allows storing multiple values of same type in a single variable
- **arrays in java** are **objects** which make then work differently than arrays in c/c++ in terms memory management.
- For **primitive arrays**, **elements** are stored in **contagious memory locations**.
- for **non-primitive arrays**, **references** to objects are stored in contagious memory locations.

#### Example
```java
public class Main {
    public static void main(String[] args) {
        // initialize an array of integers
        int[] arr = {1, 2, 3, 4, 5};

        // another method to initialize an array of integers
        int[] arr2 = new int[5]; // creates an array of size 5
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
        arr2[3] = 4;
        arr2[4] = 5;

        // print the elements of the array
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

- we can get the **length** of an array using the **length** property.


### Properties of Arrays
- In java, all arrays are **dynamically allocated**.
- **length** property is used to get the length of an array.
- array index starts from **0**.
- Java array can also be used as static field, local variable or method parameter.
- In case of array of primitive data types (int, char, etc.), the actual values are stored in contiguous memory locations.
- In case of array of objects, the references of objects are stored in contiguous memory locations and objects are stored in heap memory.
- Obtaining an array is a two-step process:
    - You must declare a variable of the desired array type.
    - You must allocate the memory that will hold the array, using **new**, and assign it to the array variable.

### Multidimensional Arrays
- Java allows us to create multidimensional arrays.
- **2D arrays** are used to store multiple arrays in a single variable.

#### Example
```java
int[][] arr = new int[3][3];
```