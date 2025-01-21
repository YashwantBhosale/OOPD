import java.util.Scanner;

public class Calculator {
    public void Calculator() {
        System.out.println("This is binary calculator! Don't get your hopes up. It only operates on two arguments of type 'int'.");
    }

    private void showMenu() {
        System.out.println("Welcome to most useful calculator in the world!");
        System.out.println("Here, you can perform .. not one, not two ... but FOUR operations!");
        System.out.print("1. add\n2. subtract\n3. Multiply\n4. Divide\n5. Exit\n");
        System.out.print("Choose (1-4): ");
    }

    private int add(int a, int b) {
        return a+b;
    }

    private int subtract(int a, int b) {
        return a-b;
    }

    private int multiply(int a, int b) {
        return a*b;
    }

    private int divide(int a, int b) {
        return a/b;
    }

    public static void main(String[] args){
        Calculator calc = new Calculator();
        Scanner reader = new Scanner(System.in);
        int a, b, option;

        while(true) {
            calc.showMenu();
            option = reader.nextInt();

            if(option == 5) break;

            System.out.print("Enter a: ");
            a = reader.nextInt();

            System.out.print("Enter b: ");
            b = reader.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("addition: " + calc.add(a, b));
                    break;
                }
                case 2: {
                    System.out.println("subtraction: " + calc.subtract(a, b));
                    break;
                }
                case 3: {
                    System.out.println("multiplication: " + calc.multiply(a, b));
                    break;
                }
                case 4: {
                    System.out.println("division: " + calc.divide(a, b));
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}