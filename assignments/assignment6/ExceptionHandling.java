import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.ClassNotFoundException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.reflect.InvocationTargetException;

abstract class Test {
    public String name;
    
    Test(String n) {
        this.name = n;
    }

    public abstract void test();
}

class MyObject {
    public String name;
    
    MyObject(String n) {
        this.name = n;
    }

    public void getName() {
        System.out.println("name: " + this.name);
    }
}

public class ExceptionHandling {
    
    // 1. ClassNotFoundException
    public static void doesClassExist(String className) {
        try {
            Class.forName(className);
            System.out.println("class " + className + " exists");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught ");
            System.out.println("class " + className + " does not exist");
        }
    }

    // 2. InterruptedException
    public static void testFunction() {
        try {
            System.out.println("thread going to sleep...");
            Thread.sleep(5000); // sleep for 5 seconds
            System.out.println("thread is alive again");
        } catch (InterruptedException e) {
            System.out.println("InterrupetedException caught ");
            System.out.println("thread was interrupted ");
        }
    }

    public static void checkInterrupt() {
        Thread t = new Thread(() -> testFunction()); // Using lambda for concise syntax

        t.start();
        
        try {
            Thread.sleep(1000); // Sleep for 1 second before interrupting
            t.interrupt();
        } catch (InterruptedException e) {
            System.out.println("InterrupetedException caught: ");
            System.out.println("main thread was interrupted: ");
        }
    }

    // 3. IOException
    public static void readFile(String fileName) {
        try { 
            FileReader reader = new FileReader(fileName);
            reader.close();
            reader.read();
        } catch (IOException e) {
            System.out.println("IOException caught ");

        }
    }

    // 4. InstantiationException
    public static void createInstance(String className) {
        try {
            Class<?> cls = Class.forName(className);
            Object obj = cls.newInstance(); // this will try to create an instance of the class which may be non existent
            System.out.println("instance of class " + className + " created: " + obj);
        } 
        catch (InstantiationException e) {
            System.out.println("InstantiationException caught");
            System.out.println("cannot instantiate class: " + className + " as it is abstract");
        } 
        // checked exception thrown by forName
        catch (ClassNotFoundException e) {
            System.out.println("ClassNOtFoundException caught");
            System.out.println("class " + className + " does not exist");
        } 
        // checked exception thrown by newInstance
        catch (IllegalAccessException e) {
            System.out.println("illegal access while creating an instance of " + className);
        } 
    }

    // 5. SQLException
    // could not find a way to simulate SQLException without using a database

    // 6. FileNotFoundException
    public static void checkFile(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            reader.read();
        } 
        catch (FileNotFoundException e) {
            System.out.println("FileNOtFoundException caught");
            System.out.println("FileNotFoundException: File '" + fileName + "' does not exist");
        } 
        // needs to be handled seperately as reader.read() signature throws IOException
        catch (IOException e) {
            System.out.println("IOException caught in checkFile()");
        }
    }

    // unchecked exceptions
    // 1. ArithmeticException
    public static void studentsPerBatch(int totalStudents, int totalBatches) {
        try {
            int studentsPerBatch = totalStudents / totalBatches;
            System.out.println("students per batch: " + studentsPerBatch);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught");
            System.out.println("cannot divide by zero");
        }
    }

    // 2. ClassCastException
    // Object because it is parent of all classes and we want to test if we can cast a string to integer
    public static void stringToInteger(Object obj) {
        try {
            int num = (int) obj;
            System.out.println("num: " + num);
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught");
            System.out.println("cannot cast string to integer");
        }
    }

    // 3. NullPointerException
    public static void getLength(String str) {
        try {
            System.out.println("length of string: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
            System.out.println("cannot get length of null string");
        }
    }

    // 4. ArrayIndexOutOfBoundsException
    public static void getLastElement(int[] arr) {
        try {
            System.out.println("last element: " + arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
            System.out.println("index out of bounds");
        }
    }

    // 5. ArrayStoreException
    // again, Object because it is parent of all classes and we want to test if we can store a string in an integer array
    public static void storeInArray(Object[] arr) {
        try {
            arr[0] = "COEP";
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException caught");
            System.out.println("cannot store string in integer array");
        }
    }

    // 6. IllegalThreadStateException
    public static void startThread(Thread t) {
        try {
            t.start();
            t.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("IllegalThreadStateException caught");
            System.out.println("thread is already started");
        }
    }
   
    public static void main(String[] args) {

        System.out.println("Testing ClassNotFoundException:");
        doesClassExist("COEP");

        System.out.println("\nTesting InterruptedException:");
        checkInterrupt();

        System.out.println("\nTesting IOException:");
        readFile("test.txt"); 

        System.out.println("\nTesting InstantiationException:");
        createInstance("Test");

        System.out.println("\nTesting FileNotFoundException:");
        checkFile("coep.txt");

        // testing unchecked exceptions
        System.out.println("\nTesting ArithmeticException:");
        studentsPerBatch(10, 0);

        System.out.println("\nTesting ClassCastException:");
        stringToInteger("123");

        System.out.println("\nTesting NullPointerException:");
        getLength(null);

        System.out.println("\nTesting ArrayIndexOutOfBoundsException:");
        int[] arr = {1, 2, 3};
        getLastElement(arr);

        System.out.println("\nTesting ArrayStoreException:");
        // we are creating an array of integers and trying to store a string in it
        // deliberately using Object[] to trigger ArrayStoreException for storing a string in an integer array
        Object[] objArr = new Integer[5];
        storeInArray(objArr);

        System.out.println("\nTesting IllegalThreadStateException:");
        Thread t = new Thread(() -> System.out.println("Thread running"));
        startThread(t);
    }

}
