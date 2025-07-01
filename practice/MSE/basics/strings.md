## Strings in Java
- used to store text
- contains a collection of characters surrounded by double quotes
- can be created using `String` class
- A `String` in java is actually an object, which contain methods that can perform certain operations on strings
- Java String is immutable, which means it is constant and cannot be changed once it has been created
- Java String is always dynamically allocated, which means it can be created and assigned memory at runtime

### Creating a String
- There are two ways to create a string in java:
    1. By string literal
    2. By `new` keyword

#### 1. By string literal
- Java String literal is created by using double quotes
- For Example:
    ```java
    String str = "Hello";
    ```
here, `str` is a reference to a string object in the heap memory

#### 2. By `new` keyword
- Java String is created by using `new` keyword
- For Example:
    ```java
    String str = new String("Hello");
    ```
- In the above example, `str` is a reference to a string object in the heap memory

### String Methods

**Note: `CharSequence` is an interface in java.**

| Method | Description | Return Type |
| --- | --- | --- |
| `charAt(int index)` | returns the character at the specified index | `char` |
| `codePointAt(int index)` | returns the Unicode of the character at the specified index | `int` |
| `codePointBefore(int index)` | returns the Unicode of the character before the specified index | `int` |
| `codePointCount(int beginIndex, int endIndex)` | returns the Unicode of the character between the specified index | `int` |
| `compareTo(String anotherString)` | compares two strings lexicographically | `int` |
| `compareToIgnoreCase(String str)` | compares two strings lexicographically, ignoring case differences | `int` |
| `concat(String str)` | concatenates the specified string to the end of this string | `String` |
| `contains(CharSequence s)` | returns true if and only if this string contains the specified sequence of char values | `boolean` |
| `copyValueOf(char[] data)` | returns a string that represents the character sequence in the array specified | `String` |
| `endsWith(String suffix)` | tests if this string ends with the specified suffix | `boolean` |
| equals(String anObject) | compares this string to the specified object | `boolean` |
| `equalsIgnoreCase(String anotherString)` | compares this string to another string, ignoring case considerations | `boolean` |
| `format(String format, Object... args)` | returns a formatted string using the specified format string and arguments | `String` |
| `getBytes()` | encodes this String into a sequence of bytes using the platform's default charset / we may specify the special encoding scheme if we want | `byte[]` |
| `getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)` | copies characters from this string into the destination character array | `void` |
| `hashCode()` | returns a hash code for this string | `int` |
| `indexOf(int ch)` | returns the index within this string of the first occurrence of the specified character | `int` |
| `intern()` | returns a canonical representation for the string object | `String` |
| `isEmpty()` | returns true if, and only if, length() is 0 | `boolean` |
| `join (CharSequence delimiter, CharSequence... elements)` | returns a string joined with the given delimiter | `String` |
| `lastIndexOf(int ch)` | returns the index within this string of the last occurrence of the specified character | `int` |
| `length()` | returns the length of this string | `int` |
| `matches(String regex)` | tells whether or not this string matches the given regular expression | `boolean` |
| `replace(char oldChar, char newChar)` | returns a **new string** resulting from replacing all occurrences of oldChar in this string with newChar | `String` |
| `replaceAll(String regex, String replacement)` | replaces each substring of this string that matches the given regular expression with the given replacement and returns new string | `String` |
| `replaceFirst(String regex, String replacement)` | replaces the first substring of this string that matches the given regular expression with the given replacement and returns new string | `String` |
| `split(String regex)` | splits this string around matches of the given regular expression | `String[]` |
| `startsWith(String prefix)` | tests if this string starts with the specified prefix | `boolean` |
| `subSequence(int beginIndex, int endIndex)` | returns a new character sequence that is a subsequence of this sequence | `CharSequence` |
| `substring(int beginIndex, int endIndex)` | returns a new string that is a substring of this string | `String` |
| `toCharArray()` | converts this string to a new character array | `char[]` |
| `toLowerCase()` | converts all of the characters in this String to lower case using the rules of the default locale | `String` |
| `toUpperCase()` | converts all of the characters in this String to upper case using the rules of the default locale | `String` |
| `toString()` | returns the value of this string object | `String` |
| `trim()` | returns a copy of the string, with leading and trailing whitespace omitted | `String` |
| `valueOf(dataType data)` | returns the string representation of the data | `String` |

**Difference between `equals()` and `contentEquals()`**
- `equalls()`: This method is used to compare a string with another string. It checks for exact character-by-character equality and returns true only if both strings have the same sequence of characters. It returns false if the argument is not a String
- `contentEquals`: This method is more versatile as it can compare a 
string with any object that implements the CharSequence interface, such as StringBuffer or StringBuilder, in addition to String. It also checks for character-by-character equality and returns true if the string has the same sequence of characters as the CharSequence.

**What is the difference between `==` and `equals()` method in Java?**
- `==` is used to compare reference of two objects, i.e., whether they are pointing to the same object or not
- `equals()` is used to compare the content of two objects

**Example of `format()` method**
```java
String str = "Hello";
System.out.println(String.format("The string is %s", str));
```

**Different Methods** (Revision Required):
- `getBytes()`: The getBytes() method in Java is used to convert a String into a byte array. It encodes the string using the platform's default charset (or a specified charset) and returns the corresponding byte array.
- `getChars()`: The getChars() method in Java is used to copy characters from a string into a destination character array. It copies characters from the specified range of the string to the destination character array starting at the specified position.
- `hashCode()`: The hashCode() method in Java is used to get the hash code of a string. It returns a hash code value for the object, in Java, a string's hash code is an integer value generated using an algorithm based on the string's content. This hash code serves as a unique identifier for the string, enabling efficient storage and retrieval in hash-based data structures like HashMaps and HashSets. 
- `intern()`: The intern() method in Java is used to ensure that string objects with the same content share the same memory reference in the string pool instead of creating new heap objects.
    - How `intern()` works?
        - when `intern()` is called on a string, Java checks whether an equal string already exists in the string pool.
        - If an equal string is found, the intern() method returns the reference to the string in the pool.
        - If no equal string is found, the intern() method adds the string to the pool and returns the reference to the newly added string.
    - **Example:**
        ```java
        public class Main {
            public static void main(String[] args) {
                String s1 = new String("Hello"); // Creates a new object in heap
                String s2 = "Hello"; // Points to the string pool

                System.out.println(s1 == s2); // false (different references)

                String s3 = s1.intern(); // Moves "Hello" to the string pool or returns existing reference
                System.out.println(s2 == s3); // true (same reference in string pool)
            }
        }
        ```
    - **When to use `intern()`?**
        - When you have a large number of strings with the same content and you want to save memory by reusing the same string object.
        - When you need to compare strings for reference equality (using the == operator) rather than content equality (using the equals() method).
        - When you want to ensure that strings with the same content share the same memory reference, which can be useful in scenarios like string interning or string comparison.
- `join()`: concatenates the given elements with the delimiter and returns the concatenated string.Note that if an element is null, then null is added.
    - **Example:**
        ```java
        // Java program to demonstrate 
        // working of join() method 

        class Gfg1 { 
            public static void main(String args[]) 
            { 
                // delimiter is "<" and elements are "Four", "Five", "Six", "Seven" 
                String gfg1 = String.join(" < ", "Four", "Five", "Six", "Seven"); 

                System.out.println(gfg1); 
            } 
        } 
        ```
    - **Output:**
        ```
        Four < Five < Six < Seven
        ```
- **`replace()`**: returns a **NEW STRING**
- Difference between `replace()` and `replaceAll()`
    - `replace()`: This method replaces all occurrences of a specified character or substring with a new character or substring. It takes two arguments: the old character or substring to be replaced and the new character or substring to replace it with. The replace() method is case-sensitive, meaning it will only replace exact matches of the specified character or substring.
    - `replaceAll()`: This method replaces all occurrences of a specified regular expression with a new string. It takes two arguments: the regular expression to match and the replacement string. The replaceAll() method is more versatile than replace() as it allows you to use regular expressions to match multiple occurrences of a pattern and replace them with a new string.
- `split()`:
    - **Example**:
    ```java
    class Main {
    public static void main(String[] args) {
            String myStr = "Split a string by spaces, and also punctuation.";
            String regex = "[,\\.\\s]";
            String[] myArray = myStr.split(regex);
            for (String s : myArray) {
                System.out.println(s);
            }
        }
    }
    ```
    - **Output**:
    ```
    Split
    a
    string
    by
    spaces

    and
    also
    punctuation
    ```
- `toString()`: The toString() method in Java is used to get a string representation of an object. It returns a string that represents the object, which can be used for debugging, logging, or displaying the object's state. The default implementation of the toString() method returns a string that consists of the class name followed by the object's hash code in hexadecimal format.
    - When we pass an object to the `System.out.println()` method, it internally calls the object's `toString()` method to get a string representation of the object and then prints it to the console.
- `valueOf()`: The `valueOf()` method is a static method in wrapper classes (`Integer`, `Double`, `Boolean`, etc.) and `String`. It converts different data types into a String or a corresponding object type.
    - **Example**:
    ```java
    String str1 = String.valueOf(100); // int to String
    String str2 = String.valueOf(12.34); // double to String
    String str3 = String.valueOf(true); // boolean to String
    String str4 = String.valueOf(new char[]{'H', 'i'}); // char array to String

    System.out.println(str1); // "100"
    System.out.println(str2); // "12.34"
    System.out.println(str3); // "true"
    System.out.println(str4); // "Hi"
    ```