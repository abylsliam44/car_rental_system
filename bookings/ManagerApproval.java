package bookings;

public class ManagerApproval extends BookingApprovalHandler {
    @Override
    public void approve(Booking booking) {
        if (booking.getAmount() < 1000) {
            System.out.println("Manager approved the booking.");
        } else if (nextHandler != null) {
            nextHandler.approve(booking);
        }
    }
}
