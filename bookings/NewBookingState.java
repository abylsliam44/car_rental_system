package bookings;

public class NewBookingState implements BookingState {
    @Override
    public BookingState next() {
        return new ConfirmedBookingState();
    }

    @Override
    public BookingState previous() {
        System.out.println("This booking is already in the new state.");
        return this;  // Не изменяем состояние
    }

    @Override
    public String getStatus() {
        return "New Booking";
    }
}
