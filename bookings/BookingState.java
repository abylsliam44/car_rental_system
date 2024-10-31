package bookings;

public interface BookingState {
    BookingState next();
    BookingState previous();
    String getStatus();
}
