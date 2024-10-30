// BookingMemento.java
public class BookingMemento {
    private final BookingState state;

    public BookingMemento(BookingState state) {
        this.state = state;
    }

    public BookingState getState() {
        return state;
    }
}
// Booking.java
public class Booking {
    private BookingState state;

    public BookingMemento saveState() {
        return new BookingMemento(state);
    }

    public void restoreState(BookingMemento memento) {
        this.state = memento.getState();
    }
}
Booking booking = new Booking();
BookingMemento savedState = booking.saveState();

booking.setState(new CompletedState());
        booking.restoreState(savedState);
