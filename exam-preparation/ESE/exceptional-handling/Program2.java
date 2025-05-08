/*
 * Write a program that takes integer inputs and displays addition 
 * handle InputMismatchException
 */
import java.util.*;

public class Program2 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int a,b;	
		try {
			a = reader.nextInt();
			b = reader.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Input mismatch exception caught!");
			System.out.println("Expected int input");
			return;
		}

		System.out.println("Sum = " + (a+b));

	}
}
