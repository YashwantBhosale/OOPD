# Objects
ref: [**Classes and Objects in Java**](https://www.geeksforgeeks.org/classes-objects-java/)

### What are objects?
Objects can be understood as **instances of a `class`** or in simple words snapshot of a class. By snapshot we mean it is shipped as a package of all the **data and function members of the class.**

as an example, consider a class `Car` which
- has data members like `speed`, `color`, `model`, etc.
- has function members like `start()`, `stop()`, `accelerate()`, etc.

Now, if we create an object of the class `Car`, it will have all the data members and function members of the class `Car`.

### How to create an object?
To create an object of a class, we use the `new` keyword followed by the class name. For example, to create an object of the class `Car`, we write:
```java
Car obj = new Car();
```

Definition of the class `Car` for reference:
```java
class Car {
    int speed;
    String color;
    String model;

    void start() {
        // logic to start the car
    }

    void stop() {
        // logic to stop the car
    }

    void accelerate() {
        // logic to accelerate the car
    }
}
```

Now, each object of the class `Car` will have its own copy of the data members and function members. For example, if we create two objects `obj1` and `obj2` of the class `Car`, then
- `obj1` will have its own copy of `speed`, `color`, `model`, etc.
- `obj2` will have its own copy of `speed`, `color`, `model`, etc.
... and so on.

### Idea behind this design of Classes and Objects
The idea behind this design is
- **reusability**. We can create multiple objects of a class and each object can have its own copy of the data members and function members. This way, we can reuse the same class to create multiple objects with different data members and function members.
- **encapsulation**. We can encapsulate the data members and function members of a class in a single
package called an object. This way, we can prevent the data members from being accessed directly from outside the class. We can provide access to the data members through the function members of the class.
- **Seperation of concerns**. We can separate the data members and function members of a class. This way, we can focus on the data members and function members separately. This makes the code more readable and maintainable.
- **Abstraction**. We can hide the implementation details of a class from the outside world. This way, we can provide a simple interface to the outside world. This makes the code more readable and maintainable.

... there are many more advantags but they make sense when we have idea about `inheritance`, `polymorphism`, `encapsulation`, etc.

### Accessing data members and function members of an object
To access the data members and function members of an object, we use the `.` operator. For example, to access the data member `speed` of the object `obj`, we write:
```java
obj.speed = 100;
```

Similarly, to access the function member `start()` of the object `obj`, we write:
```java
obj.start();
```

### Example
```java
// Assume that we have car class defined as described above

public class Main {
    public static void main(String[] args) {
        Car obj1 = new Car();
        Car obj2 = new Car();

        obj1.speed = 100;
        obj1.color = "Red";
        obj1.model = "BMW";

        obj2.speed = 120;
        obj2.color = "Blue";
        obj2.model = "Audi";

        obj1.start();
        obj2.start();
    }
}
```