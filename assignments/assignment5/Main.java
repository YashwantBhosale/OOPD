/* 
 * Write a java program to demonstrate abstract class and abstract methods in java
 * */

abstract class Bike {
	protected String name;
	protected float average;

	Bike(String name, float average) {
		this.name = name;
		this.average = average;
	}

	abstract void run();
	abstract void fillFuel();
	abstract void repair();
	
	final void start() {
		System.out.println("Bike starting ... Bike started!");
	}
	final void switchOff() {
		System.out.println("Bike switching off ... Bike switched off!");
	}

}

class Honda extends Bike {

	Honda(String name, float average){
		super(name, average);	
	}

	void run() {
		System.out.println("Honda bike is running ... ");
		System.out.println("Consider filling fuel or repairing to ensure safety!");
	}

	void fillFuel() {
		System.out.println("Filling petrol in Honda bike ... ");
	}

	void repair() {
		System.out.println("Repairing .. Honda Bike repaired!");
	}
}

class ElectricBike extends Bike {
	ElectricBike(String name, float average) {
		super(name, average);
	}

	void run() {
		System.out.println("Electric Bike is running ... ");
		System.out.println("Consider filling fuel or repairing to ensure safety!");
	}

	void fillFuel() {
		System.out.println("Charging Electric Bike ... ");
		System.out.println("Charging Complete!");
	}

	void repair() {
		System.out.println("Repairing ... Electric bike repaired!");
	}
}

public class Main {
	public static void main(String[] args) {
		Honda hondaBike = new Honda("Honda Shine", 55);

		hondaBike.start();
		hondaBike.run();
		hondaBike.repair();
		hondaBike.fillFuel();
		hondaBike.switchOff();
		System.out.println();

		ElectricBike ev = new ElectricBike("Ather", 110);

		ev.start();
		ev.run();
		ev.repair();
		ev.fillFuel();
		ev.switchOff();
	}
}
