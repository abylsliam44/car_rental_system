package bookings;

public class DirectorApproval extends BookingApprovalHandler {
    @Override
    public void approve(Booking booking) {
        if (booking.getAmount() >= 1000) {
            System.out.println("Director approved the booking.");
        }
    }
}
