package bookings;

import customers.Customer;
import cars.Car;

public class BookingMediator {
    private Customer customer;
    private Car car;

    public BookingMediator(Customer customer, Car car) {
        this.customer = customer;
        this.car = car;
    }

    public void makeBooking() {
        System.out.println("Booking made for " + customer.getName() + " with car " + car.getModel());
    }
}
