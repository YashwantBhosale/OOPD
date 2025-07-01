## Constants in Java
- **Constants** are fixed values that do not change during the execution of a program.
- Java does not directly support constants.
- There is an alternative way to define the constants in Java by using **non-access modifiers**, namely `final` and `static`.
- According to java naming conventions, constants should be in uppercase.

#### Difference between `final` and `static final` variables
- **final variable**: This variable can be assigned a value only once. It is initialized when it is created. But this constant is instance-specific.
- **static final variable**: This variable can be assigned a value only once. It is initialized at the time of class definition. This constant is class-specific. This means that all instances of the class share the same value.