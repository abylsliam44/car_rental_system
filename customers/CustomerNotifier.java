package customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerNotifier {
    private List<CustomerObserver> observers = new ArrayList<>();

    public void subscribe(CustomerObserver observer) {
        observers.add(observer);
    }

    public void notifyCustomers(String message) {
        for (CustomerObserver observer : observers) {
            observer.update(message);
        }
    }
}

interface CustomerObserver {
    void update(String message);
}

class RegularCustomerObserver implements CustomerObserver {
    @Override
    public void update(String message) {
        System.out.println("Regular customer notified: " + message);
    }
}

class VipCustomerObserver implements CustomerObserver {
    @Override
    public void update(String message) {
        System.out.println("VIP customer notified: " + message);
    }
}
