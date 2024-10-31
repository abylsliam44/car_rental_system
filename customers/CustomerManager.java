package customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private static CustomerManager instance;
    private List<Customer> customers;

    private CustomerManager() {
        customers = new ArrayList<>();
    }

    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added: " + customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
