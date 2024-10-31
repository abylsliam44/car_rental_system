package bookings;

public class Booking {
    private String id;
    private double amount;
    private BookingState state;

    public Booking(String id, double amount) {
        this.id = id;
        this.amount = amount;
        this.state = new NewBookingState();  // Инициализация начального состояния
    }

    public void moveToNextState() {
        state = state.next();
    }

    public BookingState getState() {
        return state;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return state.getStatus();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Booking{id='" + id + "', amount=" + amount + ", state=" + state.getStatus() + '}';
    }
}
