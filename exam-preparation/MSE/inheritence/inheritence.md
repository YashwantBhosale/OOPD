## Inheritence
ref: [Inheritance in Java by GeeksforGeeks](https://www.geeksforgeeks.org/inheritance-in-java/)
- In general, the approach of Object-Oriented Programming is to deliver more **reusable**, **maintainable**, and **scalable** code.
- **Inheritance** is one of the key features of OOP that allows us to create a new class by inheriting the properties and methods of an existing class.
- The class that is inherited is called the **superclass** or **parent class**.
- The class that inherits the superclass is called the **subclass** or **child class**.
- in java, we use the `extends` keyword to inherit a class.
- in Java, a class can inherit only one class, i.e., Java does not support multiple inheritances. (Multiple inheritances can be achieved using interfaces)

### Example
```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.bark();
    }
}
```

### Types of Inheritance
#### 1. Single Inheritance
![Single Inheritance](https://media.geeksforgeeks.org/wp-content/uploads/20220728111827/1-660x329.jpg)
- A class is derived from only one class.
- It inherits properties and behavior from a single class.

**Example**
```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}
```

#### 2. Multilevel Inheritance
![Multilevel Inheritance](https://media.geeksforgeeks.org/wp-content/uploads/20220728111913/2-660x329.jpg)

- A class is derived from another derived class.
- It inherits properties and behavior from a class that is already derived from another class.
- The image shows a class `A` that is derived from class `B`, which is derived from class `C`.
- class `A` inherits properties and behavior from class `B`, which, in turn, inherits properties and behavior from class `C`.
- In Java, a class cannot directly access the grandparent’s members. 

**Example**
```java
class Animal {
    void eat() {
        System.out.println("eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("barking...");
    }
}

class BabyDog extends Dog {
    void weep() {
        System.out.println("weeping...");
    }
}
```

#### 4. Hierarchical Inheritance
![Hierarchical Inheritance](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20221025185149/Hierarchical-Inheritance-in-Java.jpg)

- Multiple classes are derived from a single class.
- It inherits properties and behavior from a single class.

**Example**
```java
// Java program to illustrate the
// concept of Hierarchical  inheritance

class A {
    public void print_A() { System.out.println("Class A"); }
}

class B extends A {
    public void print_B() { System.out.println("Class B"); }
}

class C extends A {
    public void print_C() { System.out.println("Class C"); }
}

class D extends A {
    public void print_D() { System.out.println("Class D"); }
}

// Driver Class
public class Test {
    public static void main(String[] args)
    {
        B obj_B = new B();
        obj_B.print_A();
        obj_B.print_B();

        C obj_C = new C();
        obj_C.print_A();
        obj_C.print_C();

        D obj_D = new D();
        obj_D.print_A();
        obj_D.print_D();
    }
}
```

#### 4. Multiple Inheritance
- A class is derived from more than one class.
- Java does not support multiple inheritances.
- Multiple inheritances can be achieved using interfaces.
- More about interfaces [here](interfaces.md).

#### 5. Hybrid Inheritance
- It is a combination of two or more types of inheritance.
- Java does not support hybrid inheritance.
- It can be achieved using interfaces.


### `super` keyword
- The `super` keyword is used to refer to the immediate parent class object.
- It is used to call the constructor of the parent class.

**Example**
```java
class Animal {
    Animal() {
        System.out.println("animal is created");
    }
}

class Dog extends Animal {
    Dog() {
        super();
        System.out.println("dog is created");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
    }
}
```

**Output**
```
animal is created
dog is created
```