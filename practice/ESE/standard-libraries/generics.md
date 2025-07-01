### Concept of templates
- While building large-scale projects, we need the code to be compatible with any kind of data which is provided to it.
- the utility which allows us to do this is called a template (c++) or generics (java).
- The idea is to write a "generic" code which can work with any data type.
- Before generics, the java developers used Objects to store any type of data.
- The **Object** class is the super class of all classes in java. So in this case, for example, adding string to integer would not show compile time error but would throw a runtime error.
- So obviously, this way of writing code **lacked type safety**.

#### Types of Generics
1. Generic Method
    - A generic java method takes a parameter and returns some value after performing a task.
    - it is exactly like a normal method but with a type parameter.
    - The type parameter is defined in angle brackets before the return type of the method.
    - This allows methods to be used in more generalized way.
    - Here, the compiler takes care of the type safety.

    For example:
    ```java
    class Main {
        // Generic method
        public static <T extends Comparable<T>> T getMax(T a, T b) {
            return (a.compareTo(b) > 0) ? a : b;
        }

        public static void main(String[] args) {
            // Using the generic method
            int maxInt = getMax(10, 20);
            double maxDouble = getMax(10.5, 20.5);
            String maxString = getMax("apple", "banana");

            System.out.println("Max Integer: " + maxInt);
            System.out.println("Max Double: " + maxDouble);
            System.out.println("Max String: " + maxString);
        }
    }
    ```
    **Output:**
    ```
    Max Integer: 20
    Max Double: 20.5
    Max String: banana
    ```
    **Notice that `comparable` is an interface not class. Yet, we have used `extends` keyword. So even if you want to address a class which implements certain interface you have to use `extends` keyword.**

2. Generic Class
    - A generic class is a class that can operate on objects of various types while providing compile-time type safety.
    - It is defined with a type parameter in angle brackets after the class name.
    - This allows the class to be instantiated with different types.

    For example:
    ```java
    class GenericBox<T> {
        private T item;

        public void setItem(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }
    }

    public class Main {
        public static void main(String[] args) {
            GenericBox<String> stringBox = new GenericBox<>();
            stringBox.setItem("Hello");
            System.out.println("String Box: " + stringBox.getItem());

            GenericBox<Integer> intBox = new GenericBox<>();
            intBox.setItem(123);
            System.out.println("Integer Box: " + intBox.getItem());
        }
    }
    ```
    **Output:**
    ```
    String Box: Hello
    Integer Box: 123
    ```