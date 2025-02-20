## Types of variables in Java

In Java, there are three types of variables:
- Local Variables
- Instance Variables
- Static Variables

### Local Variables
- defined within **a block** or **method** or **constructor**
- **created when the control enters the block** and **destroyed when the control exits the block**
- **not initialized by default**. They must be **initialized before accessing the variable**.
- not accessible from outside the block.

Example:
```java
public class Test {
    public void method() {
        int x = 10; // local variable
        System.out.println(x);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.method();
    }
}
```
Here, `x` is a local variable.
It is defined within the method `method()`.
It is created when the control enters the method and destroyed when the control exits the method, i.e we can't access `x` outside the method.

### Instance Variables
- non-static variables
- they are declared **in a class** but **outside a method, constructor or any block**
- They are created when an object of the class is created and destroyed when the object is destroyed.
- An access modifier can be used with instance variables. More about access modifiers [here](access-modifiers.md).
- Initialization of an instance variable is **not mandatory**. Its **default value is dependent on the data type of variable**. For String it is null, for float it is 0.0f, for int it is 0, for Wrapper classes like Integer it is null, etc
- They can be accessed from outside the class using the object of the class. given that the access modifier allows it.

Example:
```java
public class Test {
    public int x = 10, y; // instance variable

    // constructor
    Test() {
        this.y = 20;
    }


    public void method() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.method();
    }
}
```

Here, `x` and `y` are instance variables.

**instance blocks** are blocks of code within a java class that are executed every time an instance of that class is created. They are defined using curly braces `{}` and are executed in the order they are defined.

Example:
```java
class MyClass {
    int x;
    
    // Instance block
    {
        x = 10;
        System.out.println("Instance block executed. x = " + x);
    }

    // Constructor
    public MyClass() {
        System.out.println("Constructor executed. x = " + x);
    }

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
    }
}
```
**Differences Between Instance Blocks and Constructors**
| Feature               | Instance Block | Constructor |
|-----------------------|---------------|------------|
| **Execution Order**   | Runs **before** the constructor | Runs **after** instance block |
| **Usage**            | Used for **common initialization** | Used for **object-specific initialization** |
| **Overloading**      |  Cannot be overloaded | Can be overloaded |
| **Explicit Call**    | Cannot be explicitly called | Can be called using `super()` or `this()` |
| **Inheritance Effect** | Runs **before** the subclass constructor | The **parent constructor runs before the child constructor** |

### Static Variables
- known as **class variables**
- declared using the keyword `static`
- unlike instance variables, **static variables are common to all instances of a class**
- created at the start of program execution and destroyed at the end of program execution
- **initialized only once**. It is initialized when the class is loaded by the JVM.
- **not mandatory to initialize static variables**. Its **default value is dependent on the data type of variable**. For String it is null, for float it is 0.0f, for int it is 0, for Wrapper classes like Integer it is null, etc
- they can be accessed without creating an object of the class.
- they can be accessed without using class name as well but it is not recommended. generally, compiler will automatically convert it to `ClassName.variableName` format. but if two classes have same static variable name then we must use `ClassName.variableName` format to access the variable.

Example:
```java
public class Test {
    public static int x = 10; // static variable

    public void method() {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Test obj = new Test();
        obj.method();
    }
}
```

**Primary difference between static and instance variables**:
- each object has its own copy of instance variables, but there is only one copy of static variables.
- changes made to static variables are reflected in all objects of the class. and changes made to instance variables are not reflected in other objects of the class.
- static variables can be accessed using class name but we need to access instance variables using object reference.
- static variables are created when the class is loaded by the JVM and destroyed when the program execution is completed. instance variables are created when an object of the class is created and destroyed when the object is destroyed.