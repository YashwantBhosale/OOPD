## Control Statements
- manage the flow of control in a program
- Types:
    1. [Decision-making statements](#decision-making-statements)
    2. [Looping statements](#looping-statements)
    3. [Jump statements](#jump-statements)

### Decision-making statements

- **if statement**
    - syntax:
    ```java
    if (condition) {
        // logic
    }
    ```
    - if the condition is true, the code inside the block will be executed
    - if the condition is false, the code inside the block will be skipped

- **if-else statement**
    - syntax:
    ```java
    if (condition) {
        // logic
    } else {
        // logic
    }
    ```
    - if the condition is true, the code inside the first block will be executed
    - if the condition is false, the code inside the second block will be executed

- **else-if statement**
    - syntax:
    ```java
    if (condition1) {
        // logic
    } else if (condition2) {
        // logic
    } else {
        // logic
    }
    ```
    - if the condition1 is true, the code inside the first block will be executed
    - if the condition1 is false and condition2 is true, the code inside the second block will be executed
    - if both conditions are false, the code inside the third block will be executed

- **switch statement**
    - syntax:
    ```java
    switch (expression) {
        case value1:
            // logic
            break;
        case value2:
            // logic
            break;
        default:
            // logic
    }
    ```
    - the expression is evaluated once and compared with the values of each case
    - if a match is found, the code inside that case will be executed
    - if no match is found, the code inside the default block will be executed
    - case labels must be unique and constant

### Looping statements
- Looping in programming languages is a feature that facilitates the execution of a set of instructions/functions repeatedly while some condition evaluates to true.
- There are three types of loops in Java:
    - **for loop**
    - **while loop**
    - **do-while loop**

#### for loop
- execute body repeatedly based on a given condition
- **We use this loop when we know the number of iterations (repetitions) beforehand.**

- syntax:
```java
for (int i = 0; i < n; i++) {
    // logic
}
```
- `i` is the loop variable
- `i < n` is the condition
- `i++` is the increment/decrement operation

#### Enhanced for loop
- introduced in Java 5
- used to iterate over arrays or collections
- syntax:
```java
for (type var : array) {
    // logic
}
```
- `type` is the data type of the array elements
- `var` is the loop variable

**Example:**
```java
class Main{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
```

#### while loop
- we use this when we want to run particular set of statements an unknown number of times and until a certain condition is met.
- syntax:
```java
while (condition) {
    // logic
}
```
- the condition is evaluated before the loop body is executed
- if the condition is true, the loop body is executed
- if the condition is false, the loop body is skipped

#### do-while loop
- similar to the while loop, but the condition is evaluated after the loop body is executed
- syntax:
```java
do {
    // logic
} while (condition);
```
- the loop body is executed at least once, regardless of the condition
- after one iteration, the do-while loop behaves like a while loop

### Jump statements
- used to transfer control from one point to another in a program
- Types:
    - **break**: used to terminate a loop or switch statement
    - **continue**: used to skip the current iteration of a loop
    - **return**: used to return from a method