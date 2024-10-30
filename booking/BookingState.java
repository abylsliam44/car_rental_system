// BookingState.java
public interface BookingState {
    void handleRequest(Booking booking);
}
// ActiveState.java
public class ActiveState implements BookingState {
    @Override
    public void handleRequest(Booking booking) {
        System.out.println("Booking is currently active.");
        // Дополнительные действия для активного состояния
    }
}

// CompletedState.java
public class CompletedState implements BookingState {
    @Override
    public void handleRequest(Booking booking) {
        System.out.println("Booking is completed.");
        // Дополнительные действия для завершенного состояния
    }
}

// CancelledState.java
public class CancelledState implements BookingState {
    @Override
    public void handleRequest(Booking booking) {
        System.out.println("Booking is cancelled.");
        // Дополнительные действия для отмененного состояния
    }
}
// Booking.java
public class Booking {
    private BookingState state;

    public Booking() {
        this.state = new ActiveState(); // Начальное состояние
    }

    public void setState(BookingState state) {
        this.state = state;
    }

    public void handleRequest() {
        state.handleRequest(this);
    }
}
