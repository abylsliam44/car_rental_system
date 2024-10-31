import cars.Car;
import cars.CarFactory;
import cars.SportsPackage;
import customers.Customer;
import customers.CustomerFactory;
import bookings.Booking;
import bookings.ManagerApproval;
import bookings.DirectorApproval;
import bookings.BookingApprovalHandler;
import billing.BillingFacade;
import billing.DiscountInterpreter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryDatabase db = InMemoryDatabase.getInstance();

        System.out.println("=== Welcome to the Ultimate Car Rental Management System! ===");
        System.out.println("Your all-in-one solution for managing cars, customers, bookings, and so much more.");
        System.out.println("Sit back, relax, and let us take you on a journey through the wonders of car rental management!");
        System.out.println("Whether you're a new user or a returning pro, we have something exciting for everyone.\n");

        while (true) {
            System.out.println("\n--- Start-Up Menu ---");
            System.out.println("1. Explore the System Features");
            System.out.println("2. Start Managing Rentals");
            System.out.println("3. About Our System");
            System.out.println("4. Exit");

            System.out.print("Please choose an option to proceed: ");
            int startChoice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (startChoice) {
                case 1:
                    displaySystemFeatures();
                    break;

                case 2:
                    System.out.println("\nAwesome! Let’s dive into the details and start managing your car rentals.");
                    showMainMenu(scanner, db);
                    break;

                case 3:
                    System.out.println("\n--- About Our System ---");
                    System.out.println("Our Car Rental Management System provides a seamless experience for managing car rentals, customer data, bookings, and even complex billing calculations.");
                    System.out.println("With a user-friendly interface, you can manage your rental business with ease and efficiency.");
                    System.out.println("Press 'Enter' to return to the Start-Up Menu...");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Thank you for choosing the Car Rental Management System! Have a great day!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private static void displaySystemFeatures() {
        System.out.println("\n--- System Features ---");
        System.out.println("1. Manage your fleet of cars, from basic models to luxury vehicles.");
        System.out.println("2. Keep track of customers and personalize their rental experience.");
        System.out.println("3. Create and manage bookings with a few simple steps.");
        System.out.println("4. Handle complex billing needs, including discounts and additional services.");
        System.out.println("5. Calculate costs with advanced pricing structures for VIP customers.");
        System.out.println("6. View comprehensive reports on all your data.");
        System.out.println("\nAre you ready to start? Head back to the Start-Up Menu and choose 'Start Managing Rentals'!");
    }

    private static void showMainMenu(Scanner scanner, InMemoryDatabase db) {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new car");
            System.out.println("2. Add a new customer");
            System.out.println("3. Create a booking");
            System.out.println("4. Add sports package to a car");
            System.out.println("5. Move booking to next state");
            System.out.println("6. Approve a booking");
            System.out.println("7. Calculate total price with discounts");
            System.out.println("8. View all cars");
            System.out.println("9. View all customers");
            System.out.println("10. View all bookings");
            System.out.println("11. Simulate discount calculation");
            System.out.println("12. Exit to Start-Up Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCar(scanner, db);
                    break;
                case 2:
                    addCustomer(scanner, db);
                    break;
                case 3:
                    createBooking(scanner, db);
                    break;
                case 4:
                    addSportsPackage(scanner, db);
                    break;
                case 5:
                    moveBookingToNextState(scanner, db);
                    break;
                case 6:
                    approveBooking(scanner, db);
                    break;
                case 7:
                    calculateTotalPrice(scanner, db);
                    break;
                case 8:
                    viewAllCars(db);
                    break;
                case 9:
                    viewAllCustomers(db);
                    break;
                case 10:
                    viewAllBookings(db);
                    break;
                case 11:
                    simulateDiscountCalculation(scanner);
                    break;
                case 12:
                    System.out.println("Returning to the Start-Up Menu...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addCar(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter car type (luxury/basic): ");
        String carType = scanner.nextLine();
        CarFactory carFactory = CarFactory.getFactory(carType);

        System.out.print("Enter car model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter car brand: ");
        String carBrand = scanner.nextLine();

        Car car = carFactory.createCar(carModel, carBrand);
        db.addCar(car);
        System.out.println("Car added: " + car);

        System.out.print("Would you like to add a sports package to this car? (yes/no): ");
        String addPackage = scanner.nextLine();
        if (addPackage.equalsIgnoreCase("yes")) {
            car = new SportsPackage(car);
            System.out.println("Sports package added to car: " + car.getModel());
        }
    }

    private static void addCustomer(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter customer type (VIP/Regular): ");
        String customerType = scanner.nextLine();
        CustomerFactory customerFactory = CustomerFactory.getFactory(customerType);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        Customer customer = customerFactory.createCustomer(customerName, customerType);
        db.addCustomer(customer);
        System.out.println("Customer added: " + customer.getName() + " (" + customer.getType() + ")");

        System.out.print("Would you like to add a booking for this customer? (yes/no): ");
        String addBooking = scanner.nextLine();
        if (addBooking.equalsIgnoreCase("yes")) {
            createBooking(scanner, db);
        }
    }

    private static void createBooking(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter booking ID: ");
        String bookingId = scanner.nextLine();
        System.out.print("Enter booking amount: ");
        double bookingAmount = scanner.nextDouble();
        scanner.nextLine();

        Booking booking = new Booking(bookingId, bookingAmount);
        db.addBooking(booking);
        System.out.println("Booking created: " + booking);
    }

    private static void addSportsPackage(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter car model to add sports package: ");
        String carModel = scanner.nextLine();
        Car car = db.getCarByModel(carModel);

        if (car != null) {
            car = new SportsPackage(car);
            System.out.println("Sports package added to " + carModel);
        } else {
            System.out.println("Car not found.");
        }
    }

    private static void moveBookingToNextState(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter booking ID to move to next state: ");
        String bookingId = scanner.nextLine();
        Booking booking = db.getBookingById(bookingId);

        if (booking != null) {
            booking.moveToNextState();
            System.out.println("Booking status updated: " + booking.getStatus());
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void approveBooking(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter booking ID for approval: ");
        String bookingId = scanner.nextLine();
        Booking booking = db.getBookingById(bookingId);

        if (booking != null) {
            BookingApprovalHandler managerApproval = new ManagerApproval();
            BookingApprovalHandler directorApproval = new DirectorApproval();
            managerApproval.setNextHandler(directorApproval);
            managerApproval.approve(booking);
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void calculateTotalPrice(Scanner scanner, InMemoryDatabase db) {
        System.out.print("Enter booking ID to calculate price: ");
        String bookingId = scanner.nextLine();
        Booking booking = db.getBookingById(bookingId);

        if (booking != null) {
            System.out.print("Does the customer have additional services? (yes/no): ");
            boolean hasAdditionalServices = scanner.nextLine().equalsIgnoreCase("yes");

            BillingFacade billingFacade = new BillingFacade();
            double totalPrice = billingFacade.calculateTotalPrice(
                    booking.getAmount(), "VIP", hasAdditionalServices);
            System.out.println("Total price: " + totalPrice);
        } else {
            System.out.println("Booking not found.");
        }
    }

    private static void viewAllCars(InMemoryDatabase db) {
        System.out.println("All available cars:");
        for (Car storedCar : db.getCars()) {
            System.out.println("Car: " + storedCar.getModel() + " by " + storedCar.getBrand());
        }
    }

    private static void viewAllCustomers(InMemoryDatabase db) {
        System.out.println("All customers:");
        for (Customer storedCustomer : db.getCustomers()) {
            System.out.println("Customer: " + storedCustomer.getName() + " (" + storedCustomer.getType() + ")");
        }
    }

    private static void viewAllBookings(InMemoryDatabase db) {
        System.out.println("All bookings:");
        for (Booking storedBooking : db.getBookings()) {
            System.out.println(storedBooking);
        }
    }

    private static void simulateDiscountCalculation(Scanner scanner) {
        System.out.print("Enter a discount expression (e.g., '100 20 + 5 *'): ");
        String discountExpression = scanner.nextLine();
        DiscountInterpreter discountInterpreter = new DiscountInterpreter();
        double discountResult = discountInterpreter.interpret(discountExpression);
        System.out.println("Discount expression result: " + discountResult);
    }
}
