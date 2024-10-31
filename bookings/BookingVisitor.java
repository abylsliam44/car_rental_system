package bookings;

public interface BookingVisitor {
    void visit(NewBooking booking);
    void visit(ConfirmedBooking booking);
}

class BookingStatusVisitor implements BookingVisitor {
    @Override
    public void visit(NewBooking booking) {
        System.out.println("Visiting new booking.");
    }

    @Override
    public void visit(ConfirmedBooking booking) {
        System.out.println("Visiting confirmed booking.");
    }
}

interface Visitable {
    void accept(BookingVisitor visitor);
}

class NewBooking implements Visitable {
    @Override
    public void accept(BookingVisitor visitor) {
        visitor.visit(this);
    }
}

class ConfirmedBooking implements Visitable {
    @Override
    public void accept(BookingVisitor visitor) {
        visitor.visit(this);
    }
}
