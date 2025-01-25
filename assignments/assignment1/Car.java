/*
 * Assignment 1: Design a car class with attributes like make, model, year, and color. Implement methods to display car details and change the car color.
 */
import java.util.Scanner;

public class Car {
	private final String model;
	private final int year;
	private String color;
	
	Car(String _model, int _year, String _color) {
		this.model = _model;
		this.year = _year;
		this.color = _color;
	}

	public void details() {
		if(model == null)
			System.out.println("Model not specified!");
		else
			System.out.println("Model: " + model);

		if(year == 0)
			System.out.println("Year not specified!");
		else
			System.out.println("Year: " + year);

		if(color == null) 
			System.out.println("Color not specified!");
		else
			System.out.println("Color: " + color);
	}
	
	public void changeColor(String color) {
		this.color = color;
	}

	public static void main(String[] args) {
		String _model = "latest";
		int year = 2025;
		String _color = "white";
		Car c = new Car(_model, year, _color);
		c.details();
		System.out.println();

		Scanner reader = new Scanner(System.in);
		System.out.println("Enter new color: ");
		String color = reader.nextLine();

		c.changeColor(color);
		c.details();
	}
}
