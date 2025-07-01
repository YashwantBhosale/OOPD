## Method Overriding and Overloading

### Method Overloading

- Method overloading is a feature that allows a class to have more than one method having the same name, if their argument lists are different. It is similar to constructor overloading in Java, that allows a class to have more than one constructor having different argument lists.
- Method overloading is a compile-time polymorphism / static polymorphism / early binding.

#### Different ways to overload a method

- By changing the number of arguments
- By changing the data type of arguments
- By changing the sequence of data type of arguments

**1. By changing the number of arguments**

```java
class Test {
    void display(int a) {
        System.out.println("Method with one argument");
    }

    void display(int a, int b) {
        System.out.println("Method with two arguments");
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.display(10);
        obj.display(10, 20);
    }
}
```

**2. By changing the data type of arguments**

```java
class Test {
    void display(int a) {
        System.out.println("Method with int argument");
    }

    void display(double a) {
        System.out.println("Method with double argument");
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.display(10);
        obj.display(10.5);
    }
}
```

**3. By changing the sequence of data type of arguments**

```java
class Test {
    void display(int a, double b) {
        System.out.println("Method with int and double arguments");
    }

    void display(double a, int b) {
        System.out.println("Method with double and int arguments");
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.display(10, 20.5);
        obj.display(10.5, 20);
    }
}
```

#### Advantages of method overloading

- improves **readability** and **reusability** of the code
- **reduces complexity** of the code
- **improves efficiency** of the program

### Method Overriding

- Method overriding is a feature that allows a subclass to provide a specific implementation of a method that is already provided by its superclass. It is similar to constructor overriding in Java, that allows a subclass to provide a specific implementation of a constructor that is already provided by its superclass.
- Method overriding is a run-time polymorphism / dynamic polymorphism / late binding.

#### Rules for Method Overriding

1.  **Method Signature must be same**: The method signature of the method in the subclass must be the same as the method signature of the method in the superclass.
2.  **Access Modifier cannot be more restrictive**: The access modifier of the method in the subclass cannot be more restrictive than the access modifier of the method in the superclass. ex. if the method in the superclass is declared as `public`, then the method in the subclass cannot be declared as `private`.
3.  **Return Type must be same or covariant**: The return type of the method in the subclass must be the same as the return type of the method in the superclass, or it must be a covariant type of the return type of the method in the superclass.
4.  **Static methods are not overridden, they are hidden**: If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass is said to hide the method in the superclass.
    **Example**:
    ```java
    class Parent {
        static void display() { System.out.println("Parent"); }
    }

    class Child extends Parent {
        static void display() { System.out.println("Child"); } // Method Hiding
    }

    public class Main {
        public static void main(String[] args) {
            Parent obj = new Child(); // Parent reference, Child object
            obj.display(); // Output: Parent (Because method hiding applies)

            Child obj2 = new Child();
                obj2.display(); // Output: Child (Calls Child’s static method)
        }
    }
    ```
        
5. **Final methods cannot be overridden**: If a method is declared as `final` in the superclass, then it cannot be overridden in the subclass. We get a compile-time error if we try to override a final method in the subclass.
6. **Constructors cannot be overridden**: Constructors cannot be overridden in Java. The subclass can have a constructor with the same name as the constructor in the superclass, but it is not considered as overriding.

#### Example of Method Overriding

```java
class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child");
    }
}
```

#### `@Override` Annotation
The `@Override` annotation is **not compulsory**, but it is **highly recommended** when overriding methods. It **helps detect errors at compile-time** if the method is not correctly overriding a method from its superclass.


### Difference between Method Overloading and Method Overriding

| Method Overloading | Method Overriding |
| --- | --- |
| Method overloading is used to increase readability of the program. | Method overriding is used to provide a specific implementation of a method that is already provided by its superclass. |
| Method overloading is performed within the same class. | Method overriding is performed in two classes that have an inheritance relationship. |
| Method overloading is a compile-time polymorphism. | Method overriding is a run-time polymorphism. |
| In method overloading, the return type of the method may or may not be the same. | In method overriding, the return type of the method must be the same or a covariant type. |
| In method overloading, the argument list must be different. | In method overriding, the argument list must be the same. |


### Why Overloading is compile-time polymorphism and Overriding is run-time polymorphism?
Overloading is considered **compile-time polymorphism** because the method to be called is determined by the **compiler** based on the method signature (number and type of parameters) at **compile time**. The JVM does not need to decide at runtime which method to execute. In contrast, **overriding** is **runtime polymorphism** because the method call is resolved **at runtime**, depending on the actual object type. Even if a parent class reference is used, the **child class’s overridden method** gets executed due to **dynamic method dispatch (late binding)**. This enables flexible and dynamic behavior in object-oriented programming.