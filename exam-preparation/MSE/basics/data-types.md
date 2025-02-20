## Data types in Java

ref: [**Data types in Java**](https://www.geeksforgeeks.org/data-types-in-java/)

### What is a data type?

Data type is a classification of data which tells the compiler or interpreter how the programmer intends to use the data. It is a way to tell the compiler what type of data is in a variable. It is used to define the variable before using it.

Java is **statically-typed** language, which means that all variables must first be declared before they can be used. This involves stating the variable's data type and name.

Java is also a **strongly-typed** language, because types are enforced by the compiler. In java, there is **No implicit type conversion**.

![Data types in Java](https://media.geeksforgeeks.org/wp-content/uploads/20240809125618/Java-Data-Types-1024.png)

### Types of data types

#### 1. **Primitive data types**

These are the most basic data types available within the Java language. There are 8: `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`.

- They are only single values and have no speacial capabilities.
- there are 8 primitive data types in Java.
- They are predefined by the language and named by a keyword.

| Type    | default value | size    | range                | description                                             |
| ------- | ------------- | ------- | -------------------- | ------------------------------------------------------- |
| byte    | 0             | 1 byte  | -128 to 127          | Used when you need to store 8-bit signed value          |
| short   | 0             | 2 bytes | -32,768 to 32,767    | Used when you need to store 16-bit signed value         |
| int     | 0             | 4 bytes | -2^31 to 2^31-1      | Used when you need to store 32-bit signed value         |
| long    | 0L            | 8 bytes | -2^63 to 2^63-1      | Used when you need to store 64-bit signed value         |
| float   | 0.0f          | 4 bytes | 1.4e-045 to 3.4e+038 | Used when you need to store 32-bit floating point value |
| double  | 0.0d          | 8 bytes | 4.9e-324 to 1.8e+308 | Used when you need to store 64-bit floating point value |
| boolean | false         | 1 bit   | true or false        | Used when you need to store only true or false value    |
| char    | '\u0000'      | 2 bytes | '\u0000' to '\uffff' | Used to store any character                             |

**Please Note the default values of the primitive data types.** Generally, the default value of a data type is 0, 0.0, false, or '\u0000'.

Note: There is also concept of **Wrapper classes** or **Wrapper data types** in Java. These are classes that allow primitive types to be accessed as objects. for ex. `Boolean`, `Integer`, etc.
<br>
#### 2. **Non-primitive data types**:

- These data types are not actually defined by Java, but are created by the programmer. Examples of non-primitive types are Strings, Arrays, Classes, Interface, etc.

- Non-primitive data types are called reference types because, they will contain **a memory address of variable values** because the reference types won't store the value directly.

**1. Strings**

- array of characters.
- Strings are immutable in Java.
- the difference between character array and string is that **string is designed to hold sequence of characters in a single variable** where as character array is a collection of seperate char-type entities.

Example declaration of a string:

```java
String str = "Hello World";
```

**2. Class**

- A class is a user-defined blueprint or prototype from which objects are created. It represents the set of properties or methods that are common to all objects of one type.
- More about classes in [this note](classes.md).

**3. Object**

- An object is an instance of a class. It is a physical entity.
- More about objects in [this note](objects.md).

**4. Interface**

- An interface is a reference type in Java, it is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.
- Interfaces specify what a class must do and not how. It is the blueprint of the class.
- **If a class implements an interface and does not provide method bodies for all functions specified in the interface, then the class must be declared abstract.**

**5. Arrays**

- An array is a collection of similar type of elements which has contiguous memory location.
- in Java, **all arrays are dynamically allocated**.
- since arrays are objects in Java, we can find their length using the object property `length`. Unlike C/C++, we don't have to pass the length of the array to the function.
- A java array variable can also be declared like other variables with [] after the data type.
- array index starts from 0.
- **Direct superclass of an array type is Object**.

- Example declaration of an array:

```java
int[] arr = new int[5];
```
