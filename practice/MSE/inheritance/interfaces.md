## Interfaces in Java

- An interface in java is a blueprint of a class that defines a set of abstract methods (methods without a body) that a class must implement.
- It is used to achieve **abstraction** and **multiple inheritance** in Java.
- An interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.
- Interfaces cannot have constructors.
- Interfaces cannot have instance fields.

- from Java 8, interfaces can have default methods and static methods. (i.e methods with a body)
- from Java 9, interfaces can have private methods.

### Example 1: Basic Interface Usage

```java
interface Animal {
    void eat();
    void sleep();
    void makeSound();
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void sleep() {
        System.out.println("Dog is sleeping...");
    }

    public void makeSound() {
        System.out.println("Dog is barking...");
    }
}

class Cat implements Animal {
    public void eat() {
        System.out.println("Cat is eating...");
    }

    public void sleep() {
        System.out.println("Cat is sleeping...");
    }

    public void makeSound() {
        System.out.println("Cat is meowing...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sleep();
        d.makeSound();

        Cat c = new Cat();
        c.eat();
        c.sleep();
        c.makeSound();
    }
}
```

### Example 2: Interface with different implementations

```java
interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting...");
    }

    public void stop() {
        System.out.println("Car is stopping...");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting...");
    }

    public void stop() {
        System.out.println("Bike is stopping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.stop();

        Bike b = new Bike();
        b.start();
        b.stop();
    }
}
```

#### Example 3: Interface with static methods
**Important points related to Static methods in Interfaces**
- Static methods are NOT inherited by the implementing class. They belong to the interface and must be called using the interface name.
- Static methods cannot be overridden in the implementing class.
- They are used as utility methods that are common to all classes implementing the interface.
- They must have a body.

```java
interface Animal {
    void eat();
    void sleep();

    static void makeSound() {
        System.out.println("Animal is making sound...");
    }
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void sleep() {
        System.out.println("Dog is sleeping...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sleep();

        Animal.makeSound();
    }
}
```

#### Example 4: Interface with default methods
**Important points related to Default methods in Interfaces**
- Default methods are inherited by the implementing class. They can be overridden in the implementing class.
- They are used to provide a default implementation of a method in the interface.
- They must have a body.

```java
interface Animal {
    void eat();
    void sleep();

    default void makeSound() {
        System.out.println("Animal is making sound...");
    }
}

class Dog implements Animal {
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void sleep() {
        System.out.println("Dog is sleeping...");
    }

    public void makeSound() {
        System.out.println("Dog is barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sleep();
        d.makeSound();
    }
}
```

#### Example 5: Multiple interface implementation

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Bird implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Bird is flying...");
    }

    public void swim() {
        System.out.println("Bird is swimming...");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();
        b.swim();
    }
}
```
