# Access Modifiers
---

The function of access modifiers is pretty straightforward. As the name suggests, they are used to control the access to the data members and function members of a class. 
They restrict the **scope** of the class, data members, and function members.
It provides **security** by preventing unauthorized access to the data members and function members.

There are four types of access modifiers in Java:
- `private`
- `default`
- `protected`
- `public`

### 1. default
If we do not specify any access modifier, then the default access modifier is applied. The default access modifier is also known as **package-private**.
The default access modifier restricts the access to the data members and function members of a class to the same package.
By package, we mean the folder in which the class is present.

### 2. private
The `private` access modifier restricts the access to the data members and function members of a class to the same class only.
It is the most restrictive access modifier. Generally, the members which are declared as `private` are not directly accessible from outside the class. So there is a concept of **getter** and **setter** methods to access and modify the `private` members.
By using these methods to modify the `private` members, we can control the access to the `private` members.

### 3. protected
The `protected` access modifier restricts the access to the data members and function members of a class to the same package and the subclasses of the class.
So if a class is inheriting the class which has `protected` members, then the subclass can access the `protected` members of the superclass. This means instance of subclass will have allocated memory for the `protected` members of the superclass.
It is comparatively less restrictive than `private` but more restrictive than `default`.

### 4. public
The `public` access modifier does not restrict the access to the data members and function members of a class. It allows the access to the data members and function members of a class from anywhere in the program.
It is the least restrictive access modifier.
