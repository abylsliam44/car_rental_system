package bookings;

public class CompletedBookingState implements BookingState {
    @Override
    public BookingState next() {
        System.out.println("This booking is already completed.");
        return this;  // Состояние не меняется
    }

    @Override
    public BookingState previous() {
        return new ConfirmedBookingState();
    }

    @Override
    public String getStatus() {
        return "Completed Booking";
    }
}
