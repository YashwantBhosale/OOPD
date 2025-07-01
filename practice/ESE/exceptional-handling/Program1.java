/*
 * Write a program that takes two integers as input and performs arithmetic division. Catch `ArithmeticException` if the divisor is zero.
 */
import java.util.Scanner;

public class Program1 {
	public static int div(int num1, int num2) {
		try {
			int result = num1/num2;	
			return result;
		} catch (ArithmeticException e) {
			System.err.println("Divide by Zero Exception!");
			return Integer.MIN_VALUE;
		}
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);	
		int a, b;

		a = reader.nextInt();
		b = reader.nextInt();
	
		System.out.println("Result after division = " + div(a, b));
	}
}
