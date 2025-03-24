# Design Patterns in Java

#### Table of Contents

-   [Introduction](#introduction)
-   [What Are Design Patterns?](#what-are-design-patterns)
-   [Why Use Design Patterns?](#why-use-design-patterns)
-   [Categories of Design Patterns](#categories-of-design-patterns)
    -   [Creational Patterns](#creational-patterns)
    -   [Structural Patterns](#structural-patterns)
    -   [Behavioral Patterns](#behavioral-patterns)
-   [Detailed Overview of Key Design Patterns](#detailed-overview-of-key-design-patterns)
    -   [Creational Patterns Detailed](#creational-patterns-detailed)
        -   [Factory Method Pattern](#factory-method-pattern)
        -   [Abstract Factory Pattern](#abstract-factory-pattern)
        -   [Singleton Pattern](#singleton-pattern)
        -   [Builder Pattern](#builder-pattern)
        -   [Prototype Pattern](#prototype-pattern)
    -   [Structural Patterns Detailed](#structural-patterns-detailed)
        -   [Adapter Pattern](#adapter-pattern)
        -   [Bridge Pattern](#bridge-pattern)
        -   [Composite Pattern](#composite-pattern)
        -   [Decorator Pattern](#decorator-pattern)
        -   [Facade Pattern](#facade-pattern)
        -   [Flyweight Pattern](#flyweight-pattern)
        -   [Proxy Pattern](#proxy-pattern)
    -   [Behavioral Patterns Detailed](#behavioral-patterns-detailed)
        -   [Chain of Responsibility Pattern](#chain-of-responsibility-pattern)
        -   [Command Pattern](#command-pattern)
        -   [Iterator Pattern](#iterator-pattern)
        -   [Mediator Pattern](#mediator-pattern)
        -   [Memento Pattern](#memento-pattern)
        -   [Observer Pattern](#observer-pattern)
        -   [State Pattern](#state-pattern)
        -   [Strategy Pattern](#strategy-pattern)
        -   [Template Method Pattern](#template-method-pattern)
        -   [Visitor Pattern](#visitor-pattern)
-   [References](#references)

---

## Introduction

In software engineering, **design patterns** are standardized solutions to common design problems. They capture best practices evolved by experienced developers over many years and can be reused in various contexts. In Java, design patterns help create robust, scalable, and maintainable code by promoting principles such as loose coupling, encapsulation, and reusability.

---

## What Are Design Patterns?

**Design patterns** are general, reusable solutions to common problems in software design. They are not finished code that can be directly inserted into a program; rather, they provide a template or blueprint for solving issues that arise frequently during development.

-   **Reusable Solutions:** Patterns encapsulate proven solutions to recurring design problems.
-   **Language Independence:** Although many examples are given in Java, the concepts are applicable across various programming languages.
-   **Communication:** They provide a common vocabulary for developers, making it easier to discuss design ideas.
-   **Best Practices:** Using design patterns encourages best practices such as separation of concerns, maintainability, and scalability.

ref:- [TutorialsPoint Design Patterns Tutorial](https://www.tutorialspoint.com/design_pattern/index.htm) and [Refactoring.Guru’s Design Patterns blog](https://refactoring.guru/design-patterns/java).

---

## Why Use Design Patterns?

Design patterns are used to:

-   **Solve Common Problems:** They provide time-tested solutions to recurring design challenges. Also, they help in avoiding common pitfalls and mistakes.
-   **Improve Code Quality:** By promoting principles like loose coupling and high cohesion, patterns help in writing cleaner, more maintainable code.
-   **Facilitate Communication:** A shared vocabulary (e.g., “Singleton” or “Factory Method”) makes it easier for developers to understand and discuss design decisions.
-   **Enhance Flexibility and Reusability:** Patterns help in creating modular designs that can be extended or modified with minimal impact on existing code.
-   **Reduce Complexity:** They simplify complex designs by breaking them down into smaller, more manageable components.

ref:- [GeeksforGeeks Java Design Patterns Tutorial](https://www.geeksforgeeks.org/java-design-patterns/).

---

## Categories of Design Patterns

Design patterns in Java are commonly grouped into three main categories:

### Creational Patterns

These patterns deal with object creation mechanisms. They provide ways to create objects while hiding the creation logic, rather than instantiating objects directly using constructors. Common creational patterns:

-   **Factory Method Pattern**
-   **Abstract Factory Pattern**
-   **Singleton Pattern**
-   **Builder Pattern**
-   **Prototype Pattern**

### Structural Patterns

Structural patterns focus on how classes and objects are composed to form larger structures. They help ensure that if one part of a system changes, the entire system doesn’t need to do the same. Key structural patterns:

-   **Adapter Pattern**
-   **Bridge Pattern**
-   **Composite Pattern**
-   **Decorator Pattern**
-   **Facade Pattern**
-   **Flyweight Pattern**
-   **Proxy Pattern**

### Behavioral Patterns

Behavioral patterns are concerned with algorithms and the assignment of responsibilities between objects. They help manage complex control flows and interactions between objects. Important behavioral patterns:

-   **Chain of Responsibility Pattern**
-   **Command Pattern**
-   **Iterator Pattern**
-   **Mediator Pattern**
-   **Memento Pattern**
-   **Observer Pattern**
-   **State Pattern**
-   **Strategy Pattern**
-   **Template Method Pattern**
-   **Visitor Pattern**

---

Below is the detailed overview of some of the key design patterns

### Creational Patterns Detailed

#### Factory Method Pattern

Here, we define an interface for creating an object, but let subclasses decide which class to instantiate. This pattern lets a class defer instantiation to subclasses.
It means that, instead of directly creating an object, we call a factory method that creates the object. This pattern is useful when a class can’t anticipate the class of objects it must create.
loose coupling means that the classes are independent of each other. This pattern promotes loose coupling by encapsulating object creation logic in a separate class.

**Description:**  
Instead of calling a constructor directly to create an object, a factory method is used. This method encapsulates the object creation process and allows for more flexible and extensible code.

**Example Scenario:**  
Imagine you need to create different types of notification objects (e.g., Email, SMS). Instead of using direct instantiation (`new EmailNotification()`), you can use a factory method that returns the appropriate type based on input.

**Advantages:**

-   Encapsulates object creation logic.
-   Promotes loose coupling.
-   Enhances flexibility and scalability.

**Drawbacks:**

-   Can introduce extra layers of abstraction.
-   May complicate the code if overused.

**Sample Code:**

```java
public interface Shape {
   void draw();
}

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}

public class ShapeFactory {

   //use getShape method to get object of type shape
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();

      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();

      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }

      return null;
   }
}

public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();

      //get an object of Rectangle and call its draw method.
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //call draw method of Rectangle
      shape2.draw();

      //get an object of Square and call its draw method.
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of square
      shape3.draw();
   }
}
```

**output:**

```
Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.
```

**When to Use:**

-   When a class cannot anticipate the class of objects it must create.
-   To centralize object creation logic for easy maintenance.

ref:- [TutorialsPoint’s Factory Pattern explanation](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm).

---

#### Abstract Factory Pattern

Provide an interface for creating families of related or dependent objects without specifying their concrete classes.

This pattern is a step beyond the Factory Method. It involves multiple factory methods grouped under a single interface. It’s used when the system needs to be independent of how its objects are created, composed, and represented.

**Advantages:**

-   Ensures consistency among products.
-   Supports the addition of new product families without changing existing code.

**Drawbacks:**

-   Can become complex as the number of products increases.

**Example:**  
i tried following example to understand the concept of abstract factory pattern
basically, we have two types of factories, one for windows and one for linux. Each factory creates a set of products (e.g., buttons, text fields) that are designed to work together.
this isolates the creation of product objects from the client code, allowing the same client code to work with different types of products.

**Sample Code:**

```java
public interface Button {
    void paint();
}

public interface TextField {
    void render();
}

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style");
    }
}

public class WindowsTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a text field in Windows style");
    }
}

public class LinuxButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Linux style");
    }
}

public class LinuxTextField implements TextField {
    @Override
    public void render() {
        System.out.println("Rendering a text field in Linux style");
    }
}

public interface GUIFactory {
    Button createButton();
    TextField createTextField();
}

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public TextField createTextField() {
        return new WindowsTextField();
    }
}

public class LinuxFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }
    @Override
    public TextField createTextField() {
        return new LinuxTextField();
    }
}
```

**When to Use:**

-   When a system must be configured with one of multiple families of products.
-   When product objects are designed to work together and you need to enforce this constraint.

ref:- [Refactoring.Guru’s Abstract Factory Pattern](https://refactoring.guru/design-patterns/abstract-factory).

---

#### Singleton Pattern

Ensure a class has only one instance and provide a global point of access to it.

The Singleton pattern restricts the instantiation of a class to one "single" instance. This is useful when exactly one object is needed to coordinate actions across the system (e.g., a configuration manager or connection pool).

**Advantages:**

-   Controlled access to a single instance.
-   Reduces namespace clutter.
-   Can be lazily initialized to optimize performance.

**Drawbacks:**

-   Can be overused; often considered an anti-pattern if it hides dependencies.
-   Difficult to unit test because of its global state.

**Example Code:**
code reference:- [GFG](https://www.geeksforgeeks.org/singleton-class-java/)

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Singleton instance says hello!");
    }
}
```

**When to Use:**

-   When exactly one instance of a class is required to coordinate actions.
-   When system-wide configurations or resources must be centralized.

ref:- [Refactoring.Guru Singleton Pattern](https://refactoring.guru/design-patterns/singleton).

---

#### Builder Pattern

Separate the construction of a complex object from its representation, so that the same construction process can create different representations.

The Builder pattern is used when an object requires multiple steps for its creation. It allows you to construct objects step by step, offering better control over the construction process. This is especially useful when dealing with objects that have many optional parameters.

**Advantages:**

-   Improves readability and maintainability for complex objects.
-   Provides a clear separation between object construction and representation.
-   Facilitates the creation of immutable objects.

**Drawbacks:**

-   Can add extra complexity to the code.
-   Overhead in creating builder classes.

**Example Code:**
code reference:- [Digital Ocean](https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java)

```java
public class Computer {
    private String CPU;
    private String RAM;

    private String GPU;
    private String storage;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.GPU = builder.GPU;
        this.storage = builder.storage;
    }

    public static class Builder {
        private String CPU;
        private String RAM;

        private String GPU = "Integrated";
        private String storage = "256GB";

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", GPU=" + GPU + ", storage=" + storage + "]";
    }
}

// following code should ideally be in main function, but i am writing it here for showing usage
Computer myComputer = new Computer.Builder("Intel i7", "16GB")
                        .setGPU("NVIDIA GTX 1660")
                        .setStorage("512GB")
                        .build();
System.out.println(myComputer);
```

**When to Use:**

-   When the construction process of an object is complex.
-   When you need to create different representations of an object using the same construction process.

For a detailed guide, refer to [Refactoring.Guru’s Builder Pattern](https://refactoring.guru/design-patterns/builder).

---

#### Prototype Pattern

Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

The Prototype pattern is used when the process of creating a new object is resource-intensive or complex. Instead of creating a new object from scratch, you clone an existing object. This pattern is particularly useful when the cost of creating a new object is high.

**Advantages:**

-   Can reduce the cost of object creation.
-   Useful for objects that have a complex initialization process.
-   Allows dynamic configuration of new objects at runtime.

**Drawbacks:**

-   Cloning can be tricky if objects contain circular references.
-   Requires careful handling of deep versus shallow copies.

**Example Code:**
following code is a simple example of prototype pattern, where we have a shape interface and a concrete prototype class Circle which implements the shape interface. We have a client class ShapeClient which takes a prototype object and creates a new shape using the prototype.

code reference:- [GFG](https://www.geeksforgeeks.org/prototype-design-pattern/)

```java
// Prototype interface
interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
}

// Concrete prototype
class Circle implements Shape {
    private String color;

    // When you create a circle, you give it a color.
    public Circle(String color) {
        this.color = color;
    }

    // This creates a copy of the circle.
    @Override
    public Shape clone() {
        return new Circle(this.color);
    }

    // This is how a circle draws itself.
    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle.");
    }
}

// Client code
class ShapeClient {
    private Shape shapePrototype;

    // When you create a client, you give it a prototype (a shape).
    public ShapeClient(Shape shapePrototype) {
        this.shapePrototype = shapePrototype;
    }

    // This method creates a new shape using the prototype.
    public Shape createShape() {
        return shapePrototype.clone();
    }
}

// Main class
public class PrototypeExample {
    public static void main(String[] args) {
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");

        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);

        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();

        // Draw the newly created red circle.
        redCircle.draw();
    }
}
```

**When to Use:**

-   When object creation is expensive or complex.
-   When you need to create an object that is a copy of an existing object with slight modifications.

ref:- [Refactoring.Guru’s Prototype Pattern](https://refactoring.guru/design-patterns/prototype).

---

### Structural Patterns Detailed

#### Adapter Pattern

Convert the interface of a class into another interface clients expect, allowing incompatible interfaces to work together.

The Adapter pattern wraps an existing class with a new interface so that it can be used in a context where a different interface is expected. It’s often used to integrate classes that otherwise couldn’t work together because of mismatched interfaces.

**Advantages:**

-   Promotes reusability of existing classes.
-   Facilitates integration between incompatible interfaces.
-   Adheres to the Open/Closed Principle by not modifying existing code.

**Drawbacks:**

-   Can add additional layers of abstraction.
-   Overuse may lead to complicated code architecture.

**Example Code:**
code referece:- [Medium Article](https://medium.com/@rajeshvelmani/bridging-the-gap-exploring-the-adapter-design-pattern-in-java-823218841a9c)

```java
// Target interface expected by the client
public interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing class with a different interface
public class AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Adapter class that implements the target interface
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer = new AdvancedMediaPlayer();

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if ("mp4".equalsIgnoreCase(audioType)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}

// Client class
public class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing MP3 file: " + fileName);
        } else if ("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}
```

**When to Use:**

-   When you need to integrate an existing class with a new interface.
-   When you want to reuse legacy code without modifying it.

ref:- [Refactoring.Guru’s Adapter Pattern](https://refactoring.guru/design-patterns/adapter).

---

#### Bridge Pattern

Decouple an abstraction from its implementation so that the two can vary independently.

The Bridge pattern separates the abstraction (what the object does) from its implementation (how it does it). This is achieved by creating two separate hierarchies—one for the abstraction and one for the implementation—that can evolve independently.

**Advantages:**

-   Reduces coupling between abstraction and implementation.
-   Enhances flexibility and extensibility.
-   Simplifies maintenance and future development.

**Drawbacks:**

-   Can result in an increased number of classes.
-   Requires careful design to properly separate concerns.

**Code Example:**  
A remote control (abstraction) that works with different types of devices (implementations) such as TVs, radios, etc.

code idea reference:- [refactoring guru](https://refactoring.guru/design-patterns/bridge/java/example)

**Sample Code Outline:**

```java
// Abstraction
public abstract class RemoteControl {
    protected Device device;
    public RemoteControl(Device device) {
        this.device = device;
    }
    public abstract void togglePower();
}

// Implementor
public interface Device {
    void turnOn();
    void turnOff();
}

// Concrete implementation
public class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is now ON");
    }
    @Override
    public void turnOff() {
        System.out.println("TV is now OFF");
    }
}

// Refined Abstraction
public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }
    @Override
    public void togglePower() {
        // Example logic: Check current status then switch state
        System.out.println("Toggling power");
        device.turnOn(); // or turnOff() based on state
    }
}
```

**When to Use:**

-   When you want to allow the abstraction and its implementation to vary independently.
-   When changing the implementation should not affect the abstraction’s interface.

ref:- [Refactoring.Guru’s Bridge Pattern](https://refactoring.guru/design-patterns/bridge).

---

#### Composite Pattern

Compose objects into tree structures to represent part-whole hierarchies, allowing clients to treat individual objects and compositions uniformly.

The Composite pattern allows you to build complex objects from simpler ones. It lets clients work in a uniform manner with both individual objects and compositions (groups) of objects.

**Advantages:**

-   Simplifies client code by treating composite structures uniformly.
-   Makes it easier to add new types of components.
-   Enhances flexibility in handling hierarchical data.

**Drawbacks:**

-   Can make the design overly general.
-   Harder to restrict types in the composite structure.

**Code Example:**
code reference:- [GFG](https://www.geeksforgeeks.org/composite-design-pattern-in-java/)

following code is a simple example of composite pattern, where we have a Task interface and two concrete classes SimpleTask and TaskList. SimpleTask represents a single task, while TaskList represents a list of tasks.

the design allows clients to treat individual tasks and task lists uniformly, as they both implement the Task interface.

```java
import java.util.ArrayList;
import java.util.List;

// Component
interface Task {
    String getTitle();
    void setTitle(String title);
    void display();
}

// Leaf
class SimpleTask implements Task {
    private String title;

    public SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }
}

// Composite
class TaskList implements Task {
    private String title;
    private List<Task> tasks;

    public TaskList(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        for (Task task : tasks) {
            task.display();
        }
    }
}

// Client
public class TaskManagementApp {
    public static void main(String[] args) {
        // Creating simple tasks
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");

        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);

        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Tasks);

        // Displaying tasks
        projectTasks.display();
    }
}

```

**When to Use:**

-   When you need to represent part-whole hierarchies.
-   When clients should be able to ignore the difference between compositions of objects and individual objects.

ref:- [Refactoring.Guru’s Composite Pattern](https://refactoring.guru/design-patterns/composite).

---

#### Decorator Pattern

Dynamically add responsibilities to an object without modifying its code. This pattern is a flexible alternative to subclassing for extending functionality.

The Decorator pattern involves wrapping an object in a decorator object that adds new behavior before or after delegating to the original object. It is particularly useful when you want to add responsibilities to objects at runtime without affecting other instances of the same class.

**Advantages:**

-   Enhances flexibility by adding responsibilities dynamically.
-   Supports the Single Responsibility Principle by dividing functionality among classes.
-   Can be combined to add multiple behaviors.

**Drawbacks:**

-   Can lead to a system with many small classes.
-   Increased complexity if overused.

**Example Code:**  
code reference:- [Digital Ocean](https://www.digitalocean.com/community/tutorials/decorator-design-pattern-in-java-example)

following code is a simple example of decorator pattern, where we have a Car interface and a concrete class BasicCar that implements the Car interface. We have a CarDecorator class that implements the Car interface and has a Car object as a field. We have two concrete decorator classes SportsCar and LuxuryCar that extend the CarDecorator class.

note that imports are removed for simplicity.

```java
public interface Car {
	public void assemble();
}

public class BasicCar implements Car {
	@Override
	public void assemble() {
		System.out.print("Basic Car.");
	}
}

public class CarDecorator implements Car {
	protected Car car;
	public CarDecorator(Car c){
		this.car=c;
	}

	@Override
	public void assemble() {
		this.car.assemble();
	}
}

public class SportsCar extends CarDecorator {
	public SportsCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}

public class LuxuryCar extends CarDecorator {
	public LuxuryCar(Car c) {
		super(c);
	}

	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Luxury Car.");
	}
}


public class DecoratorPatternTest {
	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");

		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}
}
```

output:

```
Basic Car. Adding features of Sports Car.
*****
Basic Car. Adding features of Luxury Car. Adding features of Sports Car.
```

---

#### Facade Pattern

Provide a simplified interface to a complex subsystem.

The Facade pattern defines a higher-level interface that makes a subsystem easier to use. It hides the complexity of the subsystem by exposing a simple interface.

**Advantages:**

-   Simplifies the usage of a complex system.
-   Reduces dependencies between subsystems.
-   Improves code readability and maintainability.

**Drawbacks:**

-   Can limit the flexibility of the subsystem.
-   May hide performance bottlenecks.

**When to Use:**

-   When a system is very complex or difficult to understand.
-   When you want to provide a simple interface to a complicated subsystem.

ref:- [Refactoring.Guru’s Facade Pattern](https://refactoring.guru/design-patterns/facade).

---

#### Flyweight Pattern

Reduce the memory footprint by sharing common parts of the object state between multiple objects.

The Flyweight pattern minimizes memory use by sharing as much data as possible with similar objects. It’s especially useful when working with a large number of objects that have similar characteristics.

**Advantages:**

-   Greatly reduces memory usage.
-   Improves performance when managing many objects.

**Drawbacks:**

-   Can complicate the design.
-   May lead to difficulties in managing shared states.

**When to Use:**

-   When you need to handle a large number of similar objects.
-   When shared state can be separated from unique object state.

**Example Code**
code reference:- [Medium Article](https://medium.com/@rajeshvelmani/lightweight-objects-for-efficient-performance-exploring-the-flyweight-design-pattern-in-java-4595ebfa3165)

following code is a simple example of flyweight pattern, where we have a Character interface and a concrete class ConcreteCharacter that implements the Character interface. We have a CharacterFactory class that creates and caches character objects.

```java
// Flyweight Interface - Character
public interface Character {
    void display(String font);
}
// Concrete Flyweight - ConcreteCharacter
public class ConcreteCharacter implements Character {
    private char character;
    public ConcreteCharacter(char character) {
        this.character = character;
    }
    @Override
    public void display(String font) {
        System.out.println("Character: " + character + ", Font: " + font);
    }
}
// Flyweight Factory - CharacterFactory
public class CharacterFactory {
    private Map<java.lang.Character, Character> characterCache;
    public CharacterFactory() {
        characterCache = new HashMap<>();
    }
    public Character getCharacter(char c) {
        Character character = characterCache.get(c);
        if (character == null) {
            character = new ConcreteCharacter(c);
            characterCache.put(c, character);
        }
        return character;
    }
}

public class Application {
    public static void main(String[] args) {
        CharacterFactory characterFactory = new CharacterFactory();
        Character character1 = characterFactory.getCharacter('A');
        character1.display("Arial");
        Character character2 = characterFactory.getCharacter('B');
        character2.display("Times New Roman");
        Character character3 = characterFactory.getCharacter('A');
        character3.display("Calibri");
    }
}
```

ref:- [Refactoring.Guru’s Flyweight Pattern](https://refactoring.guru/design-patterns/flyweight).

---

#### Proxy Pattern

Provide a surrogate or placeholder for another object to control access to it.

The Proxy pattern involves creating a proxy object that acts as an intermediary for requests to the real object. This allows you to add additional behavior such as lazy loading, access control, or logging without changing the original object.

**Advantages:**

-   Controls access to the real object.
-   Can add security, caching, or logging features transparently.
-   Supports lazy initialization.

**Drawbacks:**

-   Adds an extra level of indirection.
-   Can complicate the code if not implemented properly.

**When to Use:**

-   When you need to control access to an object.
-   When you want to implement lazy loading or add cross-cutting concerns like logging.

**Example code**
code reference:- [GFG](https://www.geeksforgeeks.org/proxy-design-pattern/)

in following code, we have an Image interface and a concrete class RealImage that implements the Image interface. We have a ProxyImage class that acts as a proxy for RealImage. The ProxyImage class creates a RealImage object only when the display method is called.

```java
// Subject
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // Image will be loaded from disk only when display() is called
        image.display();

        // Image will not be loaded again, as it has been cached in the Proxy
        image.display();
    }
}
```

ref:- [Refactoring.Guru’s Proxy Pattern](https://refactoring.guru/design-patterns/proxy).

---

### Behavioral Patterns Detailed

#### Chain of Responsibility Pattern

Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request.

The Chain of Responsibility pattern creates a chain of receiver objects for a request. Each object in the chain either handles the request or passes it along to the next object in the chain.

**Advantages:**

-   Reduces coupling between sender and receiver.
-   Enhances flexibility in assigning responsibilities.
-   Simplifies object interconnections.

**Drawbacks:**

-   Can lead to unhandled requests if not designed carefully.
-   Difficult to debug when the chain is long.

**Example Scenario:**  
Exception handling in a series of catch blocks.

**When to Use:**

-   When multiple objects can handle a request.
-   When you want to decouple senders and receivers.

**Example Code:**
code reference:- [GFG](https://www.geeksforgeeks.org/chain-responsibility-design-pattern/)

following code is a simple example of chain of responsibility pattern, where we have a SupportHandler interface and three concrete classes Level1SupportHandler, Level2SupportHandler, and Level3SupportHandler that implement the SupportHandler interface. Each handler can handle requests based on the priority of the request.

```java
// Handler Interface
interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}

// Concrete Handlers
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.BASIC) {
            System.out.println("Level 1 Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.INTERMEDIATE) {
            System.out.println("Level 2 Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level3SupportHandler implements SupportHandler {
    public void handleRequest(Request request) {
        if (request.getPriority() == Priority.CRITICAL) {
            System.out.println("Level 3 Support handled the request.");
        } else {
            System.out.println("Request cannot be handled.");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        // No next handler for Level 3
    }
}

// Request Class
class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}

// Priority Enum
enum Priority {
    BASIC, INTERMEDIATE, CRITICAL
}

// Main Class
public class Main {
    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);
    }
}
```

ref:- [Refactoring.Guru’s Chain of Responsibility](https://refactoring.guru/design-patterns/chain-of-responsibility).

---

#### Command Pattern

Encapsulate a request as an object, thereby letting you parameterize clients with queues, requests, and operations.

The Command pattern turns a request into a standalone object containing all information about the request. This allows you to decouple the invoker of an operation from the object that actually performs it.

**Advantages:**

-   Supports undoable operations.
-   Enables queuing or logging of requests.
-   Decouples sender from receiver.

**Drawbacks:**

-   Can lead to many command classes.
-   Overhead of creating command objects.

**When to Use:**

-   When you need to parameterize objects with actions.
-   When you require operation queuing, logging, or undo functionality.

**Example Code:**
code reference:- [Medium Article](https://medium.com/@neerukapoor/command-design-pattern-in-java-7d06dfdd31)

following code is a simple example of command pattern, where we have a DrawShape class that has methods to draw different shapes. We have a Command interface with an execute method. We have a concrete command class DrawCircleConcreteCommand that implements the Command interface and has a DrawShape object as a field. We have a SketchBoard class that acts as an invoker and has a Command object as a field.
```java
class DrawShape {
    public void drawCircle() {
        System.out.println("Drawing Circle..");
    }

    public void drawSquare() {
        System.out.println("Drawing Square..");
    }

    public void drawRectangle() {
        System.out.println("Drawing Rectangle..");
    }

    public void eraseShape(String shape) {
        System.out.println("Erasing " + shape);
    }
}
interface Command {
    public void execute();
}

class DrawCircleConcreteCommand implements Command {
    DrawShape draw;

    public DrawCircleConcreteCommand(DrawShape draw) {
        this.draw = draw;
    }

    public void execute() {
        draw.drawCircle();
    }
}

class SketchBoard {   //Invoker
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void drawTheShape() {
        command.execute();
    }
}

public class Main{
  public static void main(String[] args) {
    SketchBoard sketchBoard = new SketchBoard();  //Invoker

    DrawShape drawShape = new DrawShape("Circle..");  //Create a drawshape object this will be the receiver of the request
    Command drawCircle = new DrawCircleConcreteCommand(drawShape);  //Creating Command object and passing receiver
    sketchBoard.setCommand(drawCircle);    //pass the command to the invoker
    sketchBoard.drawTheShape();       //simulate the icon we have chosen
  }
}

```

ref:- [Refactoring.Guru’s Command Pattern](https://refactoring.guru/design-patterns/command).

---

#### Iterator Pattern

Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

The Iterator pattern separates the traversal of a collection from the collection itself. It allows clients to iterate over complex data structures without needing to know their internal structure.

**Advantages:**

-   Simplifies collection traversal.
-   Provides a standard iteration interface.
-   Hides internal structure.

**Drawbacks:**

-   May lead to concurrent modification issues if not handled properly.

**When to Use:**

-   When you need a uniform way to traverse a collection.
-   When the collection’s internal structure should remain hidden.

Learn more from [Refactoring.Guru’s Iterator Pattern](https://refactoring.guru/design-patterns/iterator).

---

#### Mediator Pattern

Reduce direct communication between objects by introducing a mediator object that handles the interactions.

The Mediator pattern centralizes complex communications and control logic between related objects, ensuring that they do not communicate directly. This reduces the dependencies between objects.

**Advantages:**

-   Reduces coupling between objects.
-   Simplifies object protocols.
-   Centralizes complex communication logic.

**Drawbacks:**

-   The mediator can become overly complex.
-   May centralize too much responsibility.

**When to Use:**

-   When many objects interact in complex ways.
-   When you want to simplify communication between objects.

ref:- [Refactoring.Guru’s Mediator Pattern](https://refactoring.guru/design-patterns/mediator).

---

#### Memento Pattern

Capture and externalize an object’s internal state so that the object can be restored to this state later without violating encapsulation.

The Memento pattern is used to save and restore the state of an object. It is useful for implementing features like undo/redo.

**Advantages:**

-   Preserves encapsulation.
-   Supports undo mechanisms.
-   Separates state saving from object logic.

**Drawbacks:**

-   Can consume significant memory if state is large.
-   Increased complexity in managing mementos.

**When to Use:**

-   When you need to restore an object’s state.
-   For implementing undo/redo functionality.

ref:- [Refactoring.Guru’s Memento Pattern](https://refactoring.guru/design-patterns/memento).

---

#### Observer Pattern

Define a one-to-many dependency so that when one object changes state, all its dependents are notified and updated automatically.

The Observer pattern allows an object (subject) to maintain a list of its dependents (observers) and notify them automatically of any state changes, usually by calling one of their methods.

**Advantages:**

-   Promotes loose coupling.
-   Supports dynamic relationships between objects.
-   Useful for event handling systems.

**Drawbacks:**

-   Can lead to unexpected updates if not managed correctly.
-   May cause performance issues if many observers are involved.

**When to Use:**

-   When an object must notify other objects about changes in its state.
-   In event-driven systems.

ref:- [Refactoring.Guru’s Observer Pattern](https://refactoring.guru/design-patterns/observer).

---

#### State Pattern

Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.

The State pattern encapsulates varying behavior for the same object based on its state. It lets you change an object’s behavior when its internal state changes, without resorting to large conditional statements.

**Advantages:**

-   Improves maintainability by localizing state-specific behavior.
-   Eliminates large conditional statements.
-   Promotes clear separation of state and behavior.

**Drawbacks:**

-   Can increase the number of classes.
-   Complexity in managing state transitions.

**When to Use:**

-   When an object must change behavior at runtime based on its state.
-   To replace complex conditional logic with state-specific classes.

ref:- [Refactoring.Guru’s State Pattern](https://refactoring.guru/design-patterns/state).

---

#### Strategy Pattern

Define a family of algorithms, encapsulate each one, and make them interchangeable so that the algorithm can vary independently from clients that use it.

The Strategy pattern allows you to choose an algorithm’s behavior at runtime. It encapsulates different algorithms in separate classes and makes them interchangeable, providing flexibility to change behavior without modifying the client code.

**Advantages:**

-   Promotes reusability of algorithms.
-   Enables easy switching of algorithms at runtime.
-   Adheres to the Open/Closed Principle.

**Drawbacks:**

-   Increased number of classes.
-   Clients must be aware of the strategies available.

**When to Use:**

-   When multiple algorithms are available for a task.
-   To switch behavior dynamically.

ref:- [Refactoring.Guru’s Strategy Pattern](https://refactoring.guru/design-patterns/strategy).

---

#### Template Method Pattern

Define the skeleton of an algorithm in a method, deferring some steps to subclasses. This pattern lets subclasses redefine certain steps of an algorithm without changing its structure.

The Template Method pattern provides a base class that implements the overall algorithm structure while allowing subclasses to override specific steps. This ensures a consistent algorithm structure while enabling customization.

**Advantages:**

-   Ensures a consistent structure for algorithms.
-   Encourages code reuse.
-   Simplifies maintenance by centralizing common behavior.

**Drawbacks:**

-   Can limit flexibility if subclasses are forced to follow the predefined structure.
-   Subclasses may only partially change the algorithm.

**When to Use:**

-   When you have a common algorithm with varying steps.
-   To enforce an algorithm’s structure while allowing customization.

**Example Code**
code reference:- [GFG](https://www.geeksforgeeks.org/template-method-design-pattern/)

following code is a simple example of template method pattern, where we have a BeverageMaker abstract class defining the template method makeBeverage. We have two concrete subclasses TeaMaker and CoffeeMaker that implement the abstract methods brew and addCondiments.

```java
// Abstract class defining the template method
abstract class BeverageMaker {
    // Template method defining the overall process
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be implemented by subclasses
    abstract void brew();
    abstract void addCondiments();

    // Common methods
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

// Concrete subclass for making tea
class TeaMaker extends BeverageMaker {
    // Implementing abstract methods
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete subclass for making coffee
class CoffeeMaker extends BeverageMaker {
    // Implementing abstract methods
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Making tea:");
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.makeBeverage();

        System.out.println("\nMaking coffee:");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
    }
}
```

ref:- [Wikipedia Template Method Pattern (Italian)](https://it.wikipedia.org/wiki/Template_method).

---

#### Visitor Pattern

Represent an operation to be performed on elements of an object structure. The Visitor pattern lets you define a new operation without changing the classes of the elements on which it operates.

The Visitor pattern separates an algorithm from the object structure it operates on by using double dispatch. A visitor class is created to perform operations on elements of an object structure, allowing new operations to be added without modifying the element classes.

**Advantages:**

-   Adds new operations without modifying object structure.
-   Centralizes related operations in one visitor class.
-   Supports the Open/Closed Principle.

**Drawbacks:**

-   Adding new element classes can be cumbersome since every visitor must be updated.
-   Can break encapsulation if not designed carefully.

**When to Use:**

-   When you need to perform operations across a complex object structure.
-   When you want to add new behavior without changing the element classes.

**Example Code:**
code reference:- [GFG](https://www.geeksforgeeks.org/visitor-design-pattern/)

following code is a simple example of visitor pattern, where we have a ShapeVisitor interface and three concrete visitor classes AreaCalculator, CircumferenceCalculator, and PositionFinder that implement the ShapeVisitor interface. We have three concrete element classes Circle, Square, and Triangle that implement the Shape interface. The elements accept the visitor and call the appropriate visit method.

```java
import java.util.ArrayList;
import java.util.List;

// Visitor interface
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Square square);
    void visit(Triangle triangle);
}

// Element interface
interface Shape {
    void accept(ShapeVisitor visitor);
}

// Concrete Elements
class Circle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Square implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Triangle implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

// Concrete Visitors
class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;
    double radiusOfCircle = 5;
    double sideOfSquare = 4;
    double baseOfTriangle = 3;
    double heightOfTriangle = 6;

    @Override
    public void visit(Circle circle) {
        // Calculate area of circle and update totalArea
        totalArea += Math.PI * Math.pow(radiusOfCircle, 2);
    }

    @Override
    public void visit(Square square) {
        // Calculate area of square and update totalArea
        totalArea += Math.pow(sideOfSquare, 2);
    }

    @Override
    public void visit(Triangle triangle) {
        // Calculate area of triangle and update totalArea
        totalArea += (baseOfTriangle * heightOfTriangle) / 2;
    }

    public double getTotalArea() {
        return totalArea;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Square());
        shapes.add(new Triangle());

        AreaCalculator areaCalculator = new AreaCalculator();
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }

        System.out.println("Total area: " + areaCalculator.getTotalArea());
    }
}
```

ref:- [Wikipedia’s Visitor Pattern](https://en.wikipedia.org/wiki/Visitor_pattern).

---


Design patterns in Java are essential tools that help solve recurring design problems using proven, best-practice solutions. By understanding and applying these patterns, you can write code that is more modular, scalable, and maintainable. Each pattern serves a specific purpose—whether it is to create objects efficiently (creational patterns), structure complex systems (structural patterns), or manage algorithms and interactions (behavioral patterns).

---

## References

-   [TutorialsPoint Design Patterns Tutorial](https://www.tutorialspoint.com/design_pattern/index.htm)
-   [Refactoring.Guru – Design Patterns in Java](https://refactoring.guru/design-patterns/java)
-   [GeeksforGeeks Java Design Patterns Tutorial](https://www.geeksforgeeks.org/java-design-patterns/)
-   [DigitalOcean Java Design Patterns Example Tutorial](https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial)
-   [Tpoint Tech – Java Design Patterns](https://www.tpointtech.com/design-patterns-in-java)
-   [Wikipedia – Decorator Pattern](https://en.wikipedia.org/wiki/Decorator_pattern)
-   [Wikipedia – Visitor Pattern](https://en.wikipedia.org/wiki/Visitor_pattern)
-   [Wikipedia – Template Method Pattern (Italian)](https://it.wikipedia.org/wiki/Template_method)
