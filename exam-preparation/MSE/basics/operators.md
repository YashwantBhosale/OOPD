## Operators in Java

As the name suggests, operators are used to perform operations on variables and values. Java provides a rich set of operators to perform operations on variables and values. 

Types of operators in java:
1. [Arithmetic Operators](#arithmetic-operators)
2. [Unary Operators](#unary-operators)
3. [Assignment Operator](#assignment-operator)
4. [Relational Operators](#relational-operators)
5. [Logical Operators](#logical-operators)
6. [Ternary Operator](#ternary-operator)
7. [Bitwise Operators](#bitwise-operators)
8. [Shift Operators](#shift-operators)
9. [instanceof Operator](#instanceof-operator)


### Arithmetic Operators
- Perform simple arithmetic operations data

following are the arithmetic operators in java:
1. \+ (Addition)
2. \- (Subtraction)
3. \* (Multiplication)
4. / (Division)
5. % (Modulus)

### Unary Operators
- Perform operations on a single operand

following are the unary operators in java:
1. \+ (Unary Plus): Indicates positive value
2. \- (Unary Minus): Indicates negative value
3. \+\+ (Increment): Increases the value by 1
4. \-\- (Decrement): Decreases the value by 1
5. ! (Logical Complement): Inverts the value of a boolean

### Assignment Operator
- Assigns a value to a variable

following are the assignment operators in java:
1. = (Simple Assignment)
2. += (Add and Assign)
3. -= (Subtract and Assign)
4. \*= (Multiply and Assign)
5. /= (Divide and Assign)
6. %= (Modulus and Assign)

### Relational Operators
- Compares two values

following are the relational operators in java:
1. == (Equal to)
2. != (Not Equal to)
3. \> (Greater than)
4. < (Less than)
5. \>= (Greater than or Equal to)
6. <= (Less than or Equal to)

### Logical Operators
- Perform logical operations on boolean values

following are the logical operators in java:
1. && (Logical AND)
2. || (Logical OR)
3. ! (Logical NOT)

### Ternary Operator
- Conditional Operator
following is the ternary operator in java:
? : (Conditional Operator)

**usage**:
```java
variable = (expression) ? value1 : value2;
```
### Bitwise Operators
- Perform bitwise operations on integer data

following are the bitwise operators in java:
1. & (Bitwise AND)
2. | (Bitwise OR)
3. ^ (Bitwise XOR)
4. ~ (Bitwise Complement)

### Shift Operators
- Perform shift operations on integer data

following are the shift operators in java:
1. << (Left Shift)
2. \>> (Right Shift)

### instanceof Operator
- Checks whether an object is an instance of a class

following is the instanceof operator in java:
`instanceof`: it takes an object and a class as arguments and returns true if the object is an instance of the class, otherwise false.

**usage**:
```java
class Test {
    public static void main(String[] args) {
        String name = "John";
        boolean result = name instanceof String;
        System.out.println(result);
    }
}
```
Here, the `instanceof` operator checks whether the variable `name` is an instance of the class `String` and returns `true` because the variable `name` is an instance of the class `String`.

### Precedence and Associativity
- **Precedence of arithmetic operators** defines the order in which expressions are evaluated.
- precedence of operators (highest to lowest):
1. `*`, `/`, `%`
2. `+`, `-`
- all expressions are evaluated from left to right, except for the assignment operator `=`, which is evaluated from right to left.

#### Example
```java
public class Main {
    public static void main(String[] args) {
        int result = 10 + 2 * 5 - 3 / 3;
        System.out.println(result);
    }
}
```

**Output**:
```
19
```
**explanation**:
- `2 * 5` is evaluated first, which results in `10`.
- `10 + 10` is evaluated next, which results in `20`.
- `3 / 3` is evaluated next, which results in `1`.
- `20 - 1` is evaluated last, which results in `19`.

#### Associativity
- **Associativity** of operators defines the order in which operators of the same precedence are evaluated.
- **Associativity of arithmetic operators** is left-to-right.

#### Use of Parentheses
- Parentheses can be used to change the order of evaluation of expressions.
- Expressions inside parentheses are evaluated first.
