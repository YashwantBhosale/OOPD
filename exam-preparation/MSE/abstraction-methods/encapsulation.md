## Encapsulation
ref: [Encapsulation by Dave Braunshweig](https://press.rebus.community/programmingfundamentals/chapter/encapsulation/)

- bundling of data and methods **that operate on that data**
- used to **hide** the values or state of a structured data object inside a class, preventing unauthorized parties' direct access to them
- publically accessible methods are provided to **manipulate** the data in a controlled way

#### Principle
The principle or core idea of encapsulation is:
*The **data** inside the object should only be accessed through a **public interface**, that is, the object's methods.*

**Encapsulation is a good idea because:**
1. The functionality is defined in **only one place**
2. it is defined in a **logical place** (with the data)
3. the data inside the object is not **modified unexptedly** by other parts of the program

#### Example
```java
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```