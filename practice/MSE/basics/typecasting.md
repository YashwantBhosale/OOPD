## Typecasting in Java
- **Typecasting** is the process of converting one data type to another. 
- When you assign a value from one primitive data type to another, it is called **typecasting**.
- To enable the use of a variable in a specific manner, this method requires **explicitly instructing java compiler** to treat a variable of one data type as another data type.

#### Syntax
```java
// Syntax for typecasting
<data_type> <variable_name> = (<data_type>) <value>;
```

#### Types of Typecasting
- **Widening Typecasting**
    - When you convert a smaller data type to a larger data type, it is called **widening typecasting**.
    - It is done automatically by the compiler.
    - It is also known as **implicit typecasting**.
    - For example, converting an `int` to a `double`.
    ```java
    int a = 10;
    double b = a; // Widening Typecasting
    ```
    - In the above example, the `int` value `10` is converted to a `double` value `10.0`.

    - In this type of typecasting, there is no loss of data.
    - target type must be larger than the source type.
    - Both data types must be compatible with each other.

- **Narrowing Typecasting**
    - When you convert a larger data type to a smaller data type, it is called **narrowing typecasting**.
    - It is done manually by the programmer.
    - It is also known as **explicit typecasting**.
    - For example, converting a `double` to an `int`.
    ```java
    double a = 10.5;
    int b = (int) a; // Narrowing Typecasting
    ```
    - In the above example, the `double` value `10.5` is converted to an `int` value `10`.

    - In this type of typecasting, there is a loss of data.
    - target type must be smaller than the source type.
    - Both data types must be compatible with each other.