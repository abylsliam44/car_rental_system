import cars.Car;
import customers.Customer;
import bookings.Booking;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Booking> bookings;

    // Singleton instance
    private static InMemoryDatabase instance;

    private InMemoryDatabase() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public static InMemoryDatabase getInstance() {
        if (instance == null) {
            instance = new InMemoryDatabase();
        }
        return instance;
    }

    // Методы для работы с автомобилями
    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null; // Если автомобиль не найден
    }

    // Методы для работы с клиентами
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Методы для работы с бронированиями
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking getBookingById(String id) {
        for (Booking booking : bookings) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null; // Если бронирование не найдено
    }
}
