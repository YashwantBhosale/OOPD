/*
Problem Statement:
Create a menu-driven program to calculate the area of different shapes:

    Circle (Input: radius)
    Rectangle (Input: length and breadth)
    Triangle (Input: base and height)
    Exit
    Use a switch case to handle the menu.
 */

import java.util.Scanner;

public class Area {
	static final double PI = 3.14159;

	public static void menu() {
		System.out.println();	
		System.out.println("1. Circle");
		System.out.println("2. Square");
		System.out.println("3. Rectangle");
		System.out.println("4. Triangle");
		System.out.println("5. Exit");
		System.out.println(" --- ");
	}

	private static double circleArea(double radius) {
		return (PI * radius * radius);
	}
	
	private static double rectangleArea(double a, double b) {
		return (a * b);
	}

	private static double triangleArea(double base, double height) {
		return (0.5 * base * height);
	}


	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
//		Area obj = new Area();
		int option;

		while(true) {
		menu();

		System.out.print("Enter option: ");
		option = reader.nextInt();
		double area = 0;

		if(option == 5) {
			break;
		}

		switch(option) {
			case 1: {
				double radius;
				System.out.print("Enter radius: ");
				radius = reader.nextDouble();

				area = circleArea(radius);
				break;
			}
			case 2: {
				double side;
				System.out.print("Enter side: ");
				side = reader.nextDouble();

				area = rectangleArea(side, side);
				break;	
			}
			case 3: {
				double a, b;
				System.out.print("Enter length and breadth: ");
				a = reader.nextDouble();
				b = reader.nextDouble();

				area = rectangleArea(a, b);
				break;	
			}
			case 4: {
				double base, height;
				System.out.print("Enter base and height: ");
				base = reader.nextDouble();
				height = reader.nextDouble();
			
				area = triangleArea(base, height);
				break;
			}
			case 5: {
				break;
			}
			default: {
				break;
			}
		}
			System.out.println("Area = " + area);
		}	
	}
}
