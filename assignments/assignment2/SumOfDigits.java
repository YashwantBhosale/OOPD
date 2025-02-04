/*
Write a program to find the sum of the digits of a number using a while loop.
Example:

    Input: 1234
    Output: 10 (1 + 2 + 3 + 4)
 */

import java.util.Scanner;

public class SumOfDigits{
	
	private static int sumOfDigits(int number) {
		int sum = 0;

		while(number > 0) {
			sum += number % 10;
			number /= 10;	
		}

		return sum;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
//		SumOfDigits obj = new SumOfDigits();

		System.out.print("Enter number: ");
		int number = reader.nextInt();
		System.out.println("Sum of all digits = " + sumOfDigits(number));
	}
}
