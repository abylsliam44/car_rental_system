package bookings;

public abstract class BookingApprovalHandler {
    protected BookingApprovalHandler nextHandler;

    public void setNextHandler(BookingApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void approve(Booking booking);
}
