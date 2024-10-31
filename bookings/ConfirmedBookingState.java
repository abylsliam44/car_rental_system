package bookings;

public class ConfirmedBookingState implements BookingState {
    @Override
    public BookingState next() {
        return new CompletedBookingState();
    }

    @Override
    public BookingState previous() {
        return new NewBookingState();
    }

    @Override
    public String getStatus() {
        return "Confirmed Booking";
    }
}
