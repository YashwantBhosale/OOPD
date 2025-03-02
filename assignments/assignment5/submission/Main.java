/*
 * Write a program to demonstrate the use of abstract classes and final classes in Java.
 */

 /*

	structure of the program:
	1. abstract class Bike
		- protected fields: name, average, health, fuel, speed
		- constructor to initialize the fields
		- abstract methods: run, fillFuel, repair
		- final methods: start, switchOff, increaseSpeed
		- getter and setter methods for health, fuel, speed
		- finalize method to show that the object is being scrapped
	
	2. Honda class extends Bike
		- constructor to call the super constructor
		- run method to run the bike
		- fillFuel method to fill the fuel
		- repair method to repair the bike

	3. ElectricBike class extends Bike
		- constructor to call the super constructor
		- run method to run the bike
		- fillFuel method to charge the battery
		- repair method to repair the bike

	4. SportsBike class extends Bike
		- constructor to call the super constructor
		- run method to run the bike
		- fillFuel method to fill the fuel
		- repair method to repair the bike
	
	5. FinalBike class
		- final class
		- private field: model
		- constructor to initialize the model
		- final method: displayModel
	
	use of final class:
	- FinalBike class is a final class
	- final classes cannot be extended
	- final methods cannot be overridden
	- final variables cannot be changed
  */


abstract class Bike {
    protected String name;
    protected float average;
    protected int health;
    protected int fuel;
    protected int speed;

    Bike(String name, float average) {
        this.name = name;
        this.average = average;
        this.health = 100;  
        this.fuel = 100;    
        this.speed = 0;     
    }

    abstract void run();
    abstract void fillFuel();
    abstract void repair();

    final void start() {
        System.out.println(name + " is starting... bike started!");
    }

    final void switchOff() {
        System.out.println(name + " is switching off... bike switched off!");
    }

    void increaseSpeed(int increment) {
        speed += increment;
        if (speed > 120) {
            System.out.println("warning! " + name + " is going too fast: " + speed + " km/h!");
        } else {
            System.out.println(name + " is now running at " + speed + " km/h.");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " is being scrapped... bike removed from the system.");
    }
}

class Honda extends Bike {

    Honda(String name, float average) {
        super(name, average);
    }

    void run() {
        if (fuel <= 0 || health <= 0) {
            System.out.println(name + " cannot run. please repair or refuel.");
            return;
        }
        fuel -= 20;
        health -= 10;
        increaseSpeed(20);
        System.out.println("current fuel: " + fuel + "%");
        System.out.println("current health: " + health + "%");
    }

    void fillFuel() {
        System.out.println("refueling " + name + "... fuel full!");
        fuel = 100;
    }

    void repair() {
        System.out.println("repairing " + name + "... bike repaired!");
        health = 100;
    }
}

class ElectricBike extends Bike {

    ElectricBike(String name, float average) {
        super(name, average);
    }

    void run() {
        if (fuel <= 0 || health <= 0) {
            System.out.println(name + " cannot run. please charge or repair.");
            return;
        }
        System.out.println(name + " is running...");
        fuel -= 15;
        health -= 10;
        increaseSpeed(25);
        System.out.println("current battery: " + fuel + "%");
        System.out.println("current health: " + health + "%");
    }

    void fillFuel() {
        System.out.println("charging " + name + "... battery full!");
        fuel = 100;
    }

    void repair() {
        System.out.println("repairing " + name + "... bike repaired!");
        health = 100;
    }
}

class SportsBike extends Bike {

    SportsBike(String name, float average) {
        super(name, average);
    }

    void run() {
        if (fuel <= 0 || health <= 0) {
            System.out.println(name + " cannot run. please repair or refuel.");
            return;
        }
        System.out.println(name + " is running at high speed... fuel, health will decrease faster.");
        fuel -= 30;
        health -= 15;
        increaseSpeed(40);
        System.out.println("current fuel: " + fuel + "%");
        System.out.println("current health: " + health + "%");
    }

    void fillFuel() {
        System.out.println("refueling " + name + "... fuel full!");
        fuel = 100;
    }

    void repair() {
        System.out.println("repairing " + name + "... bike repaired!");
        health = 100;
    }
}

final class FinalBike {
    private String model;

    FinalBike(String model) {
        this.model = model;
    }

    final void displayModel() {
        System.out.println("this is a final bike model: " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        Honda hondaBike = new Honda("Honda Shine", 55);

        hondaBike.start();
        hondaBike.run();
        hondaBike.repair();
        hondaBike.fillFuel();
        hondaBike.run();
        hondaBike.switchOff();
        System.out.println();

        ElectricBike ev = new ElectricBike("Ather 450X", 110);

        ev.start();
        ev.run();
        ev.repair();
        ev.fillFuel();
        ev.run();
        ev.switchOff();
        System.out.println();

        SportsBike sb = new SportsBike("Kawasaki Ninja", 40);

        sb.start();
        sb.run();
        sb.run();
        sb.repair();
        sb.fillFuel();
        sb.run();
        sb.switchOff();
        System.out.println();

        FinalBike fb = new FinalBike("Yamaha R15");
        fb.displayModel();

        hondaBike = null;
        ev = null;
        sb = null;
        System.gc();
    }
}

/*
 * finalize method is used for garbage collection in java
 * when an object is about to be destroyed by the garbage collector, the finalize method is called
 * we are supposed to override the finalize method in our class to perform any cleanup operations
 * here we are jsut printing a message to show that the object is being scrapped
 * 
 * the finalize method is called by the garbage collector when it determines that there are no more references to the object
 * system.gc() is used to request the garbage collector to run
 */
