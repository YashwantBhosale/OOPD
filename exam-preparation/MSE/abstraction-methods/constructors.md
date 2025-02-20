## Constructors in Java
- Special method that is used to initialize objects
- It is **automatically called** when an object is created
- It has the same name as the class
- It does not have a return type (not even `void`)

### Types of Constructors
- Default Constructor (No-arg Constructor)
- Parameterized Constructor
- Copy Constructor (Not built-in, but can be implemented)

#### Default Constructor
- takes no arugments
- automatically called when an object is created
- initializes the object with default values

**Example**
```java
class Student {
    int id;
    String name;

    // default constructor
    Student() {
        id = 0;
        name = "not set";
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display();
    }
}
```


#### Parameterized Constructor
- takes arguments
- initializes the object with the provided values

**Example**
```java
class Student {
    int id;
    String name;

    // parameterized constructor
    Student(int i, String n) {
        id = i;
        name = n;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "John");
        s1.display();
    }
}
```

#### Copy Constructor
- takes an object of the same class as an argument
- initializes the object with the values of the passed object

**Example**
```java
class Student {
    int id;
    String name;

    // parameterized constructor
    Student(int i, String n) {
        id = i;
        name = n;
    }

    // copy constructor
    Student(Student s) {
        id = s.id;
        name = s.name;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "John");
        Student s2 = new Student(s1);
        s1.display();
        s2.display();
    }
}
```

#### Key Points about Constructors
- A constructor must have **same name as the class**
- A constructor must not have a **return type**
- A constructor **DOES NOT** return a value
- if no constructor is defined in a class, the compiler automatically creates a **default constructor** with no arguments
- a constructor can be **overloaded** like other methods
- a constructor cannot be **abstract**, **static**, **final**, or **synchronized**
- a constructor can call another constructor using `this()` keyword

#### `this` keyword
- `this` keyword is used to differentiate between instance variables and local variables
- `this` keyword logically points to the current object instance
- `this()` is used to call another constructor from a constructor
