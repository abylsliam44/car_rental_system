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
        System.out.println("An advanced solution to handle all your rental needs, from cars to bookings and customer management.");
        System.out.println("Let's get started on your journey to managing rentals efficiently!");
        
        // Initial welcome menu with more options
        while (true) {
            System.out.println("\n--- Start-Up Menu ---");
            System.out.println("1. Learn about Features");
            System.out.println("2. Get Started with Rental Management");
            System.out.println("3. System Overview");
            System.out.println("4. Exit");

            System.out.print("Select an option to proceed: ");
            int startChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (startChoice) {
                case 1:
                    displaySystemFeatures();
                    break;
                case 2:
                    System.out.println("Excellent! Let's dive into managing rentals.");
                    showMainMenu(scanner, db);
                    break;
                case 3:
                    showSystemOverview(scanner);
                    break;
                case 4:
                    System.out.println("Thanks for using the Car Rental Management System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displaySystemFeatures() {
        System.out.println("\n--- System Features ---");
        System.out.println("1. Add, view, and manage your fleet of cars, from economy to luxury models.");
        System.out.println("2. Maintain customer records and offer personalized rental experiences.");
        System.out.println("3. Create, manage, and update bookings seamlessly.");
        System.out.println("4. Complex billing calculations, including discounts, add-ons, and VIP pricing.");
        System.out.println("5. Comprehensive management of your data.");
        System.out.println("Ready to explore? Head back to the Start-Up Menu and choose 'Get Started with Rental Management'!");
    }

    private static void showSystemOverview(Scanner scanner) {
        System.out.println("\n--- System Overview ---");
        System.out.println("Our Car Rental Management System is designed for ease and efficiency.");
        System.out.println("With a friendly interface, you can handle your business needs in no time.");
        System.out.println("Press 'Enter' to return to the Start-Up Menu...");
        scanner.nextLine();
    }

    private static void showMainMenu(Scanner scanner, InMemoryDatabase db) {
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a New Car");
            System.out.println("2. Add a New Customer");
            System.out.println("3. Create a Booking");
            System.out.println("4. Add Sports Package to a Car");
            System.out.println("5. Move Booking to Next State");
            System.out.println("6. Approve a Booking");
            System.out.println("7. Calculate Total Price with Discounts");
            System.out.println("8. View All Cars");
            System.out.println("9. View All Customers");
            System.out.println("10. View All Bookings");
            System.out.println("11. Simulate Discount Calculation");
            System.out.println("12. Show Summary of All Data");
            System.out.println("13. Return to Start-Up Menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    showSummary(db);
                    break;
                case 13:
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
        System.out.print("Enter a discount expression (e.g., '100 + 20 * 5'): ");
        String discountExpression = scanner.nextLine();
        DiscountInterpreter discountInterpreter = new DiscountInterpreter();
    
        try {
            double discountResult = discountInterpreter.interpret(discountExpression);
            System.out.println("Discount expression result: " + discountResult);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }
    }

    private static void showSummary(InMemoryDatabase db) {
        System.out.println("\n--- System Summary ---");
        viewAllCars(db);
        viewAllCustomers(db);
        viewAllBookings(db);
        System.out.println("Thank you for reviewing the data. Returning to Main Menu...");
    }
}
