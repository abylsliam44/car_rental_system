import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cars.Car;

public class Database {

    // Список всех автомобилей в системе (абстрактный пример)
    private static List<Car> cars = new ArrayList<>();
    
    // Список всех клиентов в системе
    private static List<Customer> customers = new ArrayList<>();
    
    // Список всех бронирований
    private static List<Booking> bookings = new ArrayList<>();

    // Список всех дополнительных услуг
    private static List<ServicePackage> servicePackages = new ArrayList<>();

    // Мапа для хранения скидок и дополнительных услуг
    private static Map<Integer, Double> discounts = new HashMap<>();

    // Метод для инициализации данных автомобилей
    public static void initializeCars() {
        cars.add(new Car(1, "SUV", "Black", "V6 Engine"));
        cars.add(new Car(2, "Sedan", "White", "V4 Engine"));
        cars.add(new Car(3, "Electric", "Blue", "Electric Engine"));
    }

    // Метод для инициализации данных клиентов
    public static void initializeCustomers() {
        customers.add(new Customer(1, "John Doe", "john@example.com"));
        customers.add(new Customer(2, "Jane Smith", "jane@example.com"));
    }

    // Метод для инициализации данных бронирований
    public static void initializeBookings() {
        Booking booking1 = new Booking(1, getCustomerById(1), getCarById(1));
        Booking booking2 = new Booking(2, getCustomerById(2), getCarById(3));
        bookings.add(booking1);
        bookings.add(booking2);
    }

    // Метод для инициализации сервисов
    public static void initializeServices() {
        servicePackages.add(new ServicePackage("GPS", 15.0));
        servicePackages.add(new ServicePackage("Insurance", 50.0));
        servicePackages.add(new ServicePackage("Premium Seats", 25.0));
    }

    // Метод для инициализации скидок
    public static void initializeDiscounts() {
        discounts.put(1, 0.1); // 10% скидка для клиента 1
        discounts.put(2, 0.15); // 15% скидка для клиента 2
    }

    // Получение автомобиля по ID
    public static Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    // Получение клиента по ID
    public static Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    // Получение бронирования по ID
    public static Booking getBookingById(int id) {
        for (Booking booking : bookings) {
            if (booking.getId() == id) {
                return booking;
            }
        }
        return null;
    }

    // Получение всех автомобилей
    public static List<Car> getAllCars() {
        return cars;
    }

    // Получение всех клиентов
    public static List<Customer> getAllCustomers() {
        return customers;
    }

    // Получение всех бронирований
    public static List<Booking> getAllBookings() {
        return bookings;
    }

    // Получение всех доступных сервисов
    public static List<ServicePackage> getAllServicePackages() {
        return servicePackages;
    }

    // Получение скидки для конкретного клиента
    public static double getDiscountForCustomer(int customerId) {
        return discounts.getOrDefault(customerId, 0.0);
    }
}
