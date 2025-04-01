import java.util.Scanner;
import java.util.Vector;

public class Main {
    private static Vector<Venue> venues = new Vector<>();
    private static Vector<User> users = new Vector<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSystem();

        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageVenues();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    bookVenue();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    viewVenueDetails();
                    break;
                case 6:
                    manageWaitingQueue();
                    break;
                case 0:
                    System.out.println("Thank you for using the Venue Booking System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSystem() {
        Vector<Slot> auditoriumSlots = new Vector<>();
        auditoriumSlots.add(new Slot("Morning"));
        auditoriumSlots.add(new Slot("Afternoon"));
        auditoriumSlots.add(new Slot("Evening"));

        Vector<Slot> labSlots = new Vector<>();
        labSlots.add(new Slot("Session1"));
        labSlots.add(new Slot("Session2"));

        venues.add(VenueFactory.createVenue("Main Auditorium", 200, auditoriumSlots));
        venues.add(VenueFactory.createVenue("Cognizant Lab", 50, labSlots));
        venues.add(VenueFactory.createVenue("Seminar Hall", 100, auditoriumSlots));
        venues.add(VenueFactory.createVenue("FOSS Lab", 75, labSlots));
        venues.add(VenueFactory.createVenue("Academic Complex", 150, auditoriumSlots));

        users.add(new User("yashwant"));
        users.add(new User("suswan"));
        users.add(new User("alhad"));
        users.add(new User("aryan"));
        users.add(new User("tanishq"));
        users.add(new User("hardik"));
    }

    private static void displayMainMenu() {
        System.out.println("\n===== Venue Booking System =====");
        System.out.println("1. Manage Venues");
        System.out.println("2. Manage Users");
        System.out.println("3. Book a Venue");
        System.out.println("4. Cancel Booking");
        System.out.println("5. View Venue Details");
        System.out.println("6. Manage Waiting Queue");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void manageVenues() {
        while (true) {
            System.out.println("\n===== Venue Management =====");
            System.out.println("1. List All Venues");
            System.out.println("2. Add New Venue");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listVenues();
                    break;
                case 2:
                    addNewVenue();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listVenues() {
        System.out.println("\n===== Available Venues =====");
        for (int i = 0; i < venues.size(); i++) {
            System.out.println((i + 1) + ". " + venues.get(i).getDetails());
        }
    }

    private static void addNewVenue() {
        System.out.print("Enter Venue Type (Main Auditorium/Cognizant Lab/Seminar Hall/FOSS Lab/Academic Complex): ");
        String venueType = scanner.next();
        
        System.out.print("Enter Venue Capacity: ");
        int capacity = scanner.nextInt();

        Vector<Slot> slots = new Vector<>();
        while (true) {
            System.out.print("Enter Slot Name (or 0 to finish): ");
            String slotName = scanner.next();
            if (slotName.equals("0")) break;
            slots.add(new Slot(slotName));
        }

        Venue newVenue = VenueFactory.createVenue(venueType, capacity, slots);
        if (newVenue != null) {
            venues.add(newVenue);
            System.out.println("Venue added successfully!");
        }
    }

    private static void manageUsers() {
        while (true) {
            System.out.println("\n===== User Management =====");
            System.out.println("1. List Users");
            System.out.println("2. Add New User");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listUsers();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listUsers() {
        System.out.println("\n===== Registered Users =====");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName());
        }
    }

    private static void addNewUser() {
        System.out.print("Enter User Name: ");
        String userName = scanner.next();
        User newUser = new User(userName);
        users.add(newUser);
        System.out.println("User added successfully!");
    }

    private static void bookVenue() {
        listVenues();
        System.out.print("Select Venue Number: ");
        int venueIndex = scanner.nextInt() - 1;

        Venue selectedVenue = venues.get(venueIndex);
        selectedVenue.viewSlots();

        System.out.print("Enter Slot Name: ");
        String slotName = scanner.next();

        listUsers();
        System.out.print("Select User Number: ");
        int userIndex = scanner.nextInt() - 1;

        User selectedUser = users.get(userIndex);

        if (selectedVenue.book(slotName, selectedUser)) {
            System.out.println("Booking successful!");
        } else {
            System.out.println("Booking failed. Would you like to join the waiting queue? (1=Yes, 0=No)");
            if (scanner.nextInt() == 1) {
                selectedVenue.joinQueue(slotName, selectedUser);
            }
        }
    }

    private static void cancelBooking() {
        listVenues();
        System.out.print("Select Venue Number: ");
        int venueIndex = scanner.nextInt() - 1;

        Venue selectedVenue = venues.get(venueIndex);
        selectedVenue.viewSlots();

        System.out.print("Enter Slot Name to Cancel: ");
        String slotName = scanner.next();

        selectedVenue.cancelBooking(slotName);
    }

    private static void viewVenueDetails() {
        listVenues();
        System.out.print("Select Venue Number to View Details: ");
        int venueIndex = scanner.nextInt() - 1;

        Venue selectedVenue = venues.get(venueIndex);
        selectedVenue.viewSlots();
        selectedVenue.viewQueue();
    }

    private static void manageWaitingQueue() {
        listVenues();
        System.out.print("Select Venue Number: ");
        int venueIndex = scanner.nextInt() - 1;

        Venue selectedVenue = venues.get(venueIndex);

        while (true) {
            System.out.println("\n===== Waiting Queue Management =====");
            System.out.println("1. View Queue");
            System.out.println("2. Join Queue");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    selectedVenue.viewQueue();
                    break;
                case 2:
                    listUsers();
                    System.out.print("Select User Number: ");
                    int userIndex = scanner.nextInt() - 1;

                    User selectedUser = users.get(userIndex);
                    selectedVenue.viewSlots();
                    System.out.print("Enter Slot Name to Join Queue: ");
                    String slotName = scanner.next();

                    selectedVenue.joinQueue(slotName, selectedUser);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}