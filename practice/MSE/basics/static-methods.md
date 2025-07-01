## Static Methods in java
- Static methods are the methods in Java that can be called without creating an object of class.
- they belong to class rather than any specific instance of the class.
- they can be called using class name as `ClassName.methodName()`.
- they can access static data member and can change the value of it.
- they can not access non-static data member or call non-static method directly.
- generally static methods are used as utility methods.
- they are used for **operations that don't depend on instance variables.**
- can be **overloaded**
- they cannot be **overrideen** in true sense of polymorphism because they are not associated with any instance of the class.

### Example
```java
class StaticExample{
    // Static Variable
    static String greeting = "Hello, World!";

    // Static Method
    static void greet() {
        System.out.println(greeting);
    }

    // Non-Static Method
    void nonStaticGreet() {
        System.out.println(greeting);
    }

    public static void main(String[] args) {
        // Calling static method (with class name)
        StaticExample.greet();

        // Calling non-static method
        // nonStaticGreet(); // This will give error

        // Creating object of class
        StaticExample obj = new StaticExample();
        obj.nonStaticGreet();
    }
}
```