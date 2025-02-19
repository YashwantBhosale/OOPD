# Classes
ref: **[Java Classes and Objects](https://www.geeksforgeeks.org/classes-objects-java/)**
- Classes and objects are used to represent **real-world concepts and entities.**
- The class represents a group of objects having **similar properties and behaviour.**

### Difference between Classes and Objects in java
| **Class** | **Object** |
| --------- | ---------- |
| Class is the blueprint of an object. It is used to create objects. | An object is an instance of the class |
| No memory is allocated when the class is created. | Memory is allocated when an object is created. |
| Class is a logical entity. | Object is a physical entity. |
| Class can only be declared once. | Objects can be created multiple times. |
| Class is created using the `class` keyword. | Object is created using the `new` keyword. |

### Class in Java
- A **class in Java** is a set of objects that share common characteristics and properties.
- It is a user-defined blueprint or prototype from which objects are created.
- A class may be understood as a user-defined data type that defines signature, attributes, and methods of objects.

### Properties of a Class
- **Class is not a real-world entity.** it is a template from which objects are created.
- **Class does NOT occupy memory.**
- Class is a group of **variables of different data types** and **methods.**
- **Variables** are used to represent data.
- **Methods** are used to represent the behaviour of an object.
- This cluster of variables and methods defines class as a **logical entity.**

### Creating a class in java
- A class is created using the `class` keyword.
- The class definition is a block of code that contains the following:
  - **Access Modifiers:** It defines the access type of the class.
  - **Class Name:** It is the name of the class.
  - **Class Body:** It is a block of code that contains the methods, variables, constructors, etc.

```java
public class Student {
    // Variables
    long mis;
    int age;
    String name;

    // Method
    void displayInfo() {
        System.out.println(id + " " + name);
    }
}
```

Now, here
- `public` is an access modifier.
- `Student` is the name of the class.
- `mis`, `age`, `name` are the variables.
- `displayInfo()` is a method.

### Creating an object in java
- An object is an instance of a class.
- By instance, we mean that it is a snapshot of the class with some default values. It is a package of data and methods which are declared at the time of class definition.
- An object is created using the `new` keyword.

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Student class
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "John";
        s1.displayInfo();
    }
}
```