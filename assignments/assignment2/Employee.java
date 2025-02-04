/*
A company wants to calculate bonuses for its employees based on their years of service.

    Input the number of employees.
    For each employee, input their name, salary, and years of service.
    Bonus Rules:
        If the service is greater than 10 years, bonus = 20% of salary.
        If the service is between 5 and 10 years, bonus = 10% of salary.
        If the service is less than 5 years, no bonus.
    Display the name, salary, and bonus for each employee. Requirements:

    Use loops to iterate over employees.
    Use decision-making statements to calculate the bonus.
 */
import java.util.Scanner;

public class Employee {
    final private String name;
    final private double salary;
    final private int years;
    private double bonus;

    Employee(String name, double salary, int years) {
        this.name = name;
        this.salary = salary;
        this.years = years;
        this.bonus = 0;
    }

    private void calculateBonus() {
        if(this.years < 5) {
            this.bonus = 0;
        }else if(this.years > 10) {
            this.bonus = 0.2 * this.salary;
        }else {
            this.bonus = 0.1 * this.salary;
        }
    }

    public void details() {
        System.out.println();
        System.out.println("Name: " + this.name);
        System.out.println("Years of service: " + this.years);
        System.out.println("Salary (with bonus): " + (this.salary + this.bonus));
        System.out.println("Bonus: " + this.bonus);
        System.out.println(" --- ");
    }

    public static void main(String[] args) {
        int numberOfEmployees;
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter number of Employees: ");
        numberOfEmployees = reader.nextInt();
        Employee[] people = new Employee[numberOfEmployees];

        for(int i = 0; i < numberOfEmployees; i++) {
            String name;
            double salary;
            int years;
            System.out.println("Employee no. " + (i+1));
            reader.nextLine();
            System.out.print("Enter name: ");
            name = reader.nextLine();

            System.out.print("Enter salary: ");
            salary = reader.nextDouble();

            System.out.print("Enter years of service: ");
            years = reader.nextInt();

            people[i] = new Employee(name, salary, years);
        }

        System.out.println("\n--- Bonus report ---");
        for(int j = 0; j < numberOfEmployees; j++) {
            people[j].calculateBonus();
            people[j].details();
        }
    }
}