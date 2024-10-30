// BookingVisitor.java
public interface BookingVisitor {
    void visit(ActiveBooking booking);
    void visit(CompletedBooking booking);
}
// BookingAuditVisitor.java
public class BookingAuditVisitor implements BookingVisitor {
    @Override
    public void visit(ActiveBooking booking) {
        System.out.println("Auditing active booking.");
    }

    @Override
    public void visit(CompletedBooking booking) {
        System.out.println("Auditing completed booking.");
    }
}
BookingVisitor visitor = new BookingAuditVisitor();
booking.accept(visitor);
