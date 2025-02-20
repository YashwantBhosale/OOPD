## Abstract Classes and Methods

### Abstract Classes

- By definition, an abstract class is **abstract** because it serves as a blueprint for other classes. It is not meant to be instantiated on its own. So it is "abstract" in a sense that it is incomplete.
- Abstract classes are declared using the `abstract` keyword.
- Abstract classes can have both abstract and non-abstract methods.
- it can also have concrete methods- methods with a body, subclass can use these methods as they are or override them.
- Abstract classes can have constructors.
- it promotes code reusability and reduces redundancy.


#### abstract methods
A method that is declared as abstract and doesn't have implementation is called an abstract method. Abstract methods are declared using the `abstract` keyword. Abstract methods are meant to be implemented by the subclass.

```java
abstract class Bike{
    abstract void run();
}

class Honda extends Bike{
    void run(){
        System.out.println("running safely");
    }

    public static void main(String args[]){
        Bike obj = new Honda();
        obj.run();
    }
}
```

#### When to use abstract classes
Use an abstract class in Java when you need a base class that provides common functionality while enforcing specific method implementations in its subclasses. 
It is useful when:
- You want to define a template with some methods already implemented.
- You need partial abstraction (some methods implemented, some not)
- You want to enforce common behviour across multiple related classes.
- You have shared state that subclasses should inherit.


#### When to use Abstract class Instead of Interface
| Use Case | Abstract Class | Interface |
|----------|----------------|-----------|
| Need to share common state / behaviour | Yes | No |
| Need to enforce method implementation | Yes | Yes |
| Need 100% abstraction | No | Yes |
| Need to inherit from multiple classes | No | Yes |

### Abstract Classes vs Interfaces
| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| Methods | Can have abstract and concrete methods | Can only have abstract methods (Until Java 8)|
| Variables | Can have instance variables | Can only have static final variables |
| Constructors | Can have constructors | Cannot have constructors |
| Access Modifiers | Can have any access modifier | Can only have public access modifier |
| Inheritance | Can extend only one class | Can implement multiple interfaces |


