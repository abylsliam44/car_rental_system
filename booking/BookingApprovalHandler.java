// BookingApprovalHandler.java
public abstract class BookingApprovalHandler {
    protected BookingApprovalHandler nextHandler;

    public void setNextHandler(BookingApprovalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(BookingRequest request);
}
// CarAvailabilityHandler.java
public class CarAvailabilityHandler extends BookingApprovalHandler {
    @Override
    public void handleRequest(BookingRequest request) {
        if (/* условие доступности автомобиля */) {
            System.out.println("Car is available.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("Car is not available.");
        }
    }
}

// CustomerCreditHandler.java
public class CustomerCreditHandler extends BookingApprovalHandler {
    @Override
    public void handleRequest(BookingRequest request) {
        if (/* условие кредитоспособности клиента */) {
            System.out.println("Customer credit is sufficient.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("Customer credit is insufficient.");
        }
    }
}
BookingRequest request = new BookingRequest(customerId, carId);
BookingApprovalHandler carAvailability = new CarAvailabilityHandler();
BookingApprovalHandler customerCredit = new CustomerCreditHandler();

carAvailability.setNextHandler(customerCredit);
carAvailability.handleRequest(request);
