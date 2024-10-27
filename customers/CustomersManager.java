public class CustomerManager {
    private static CustomerManager instance;
    private List<Customer> customers = new ArrayList<>();

    private CustomerManager() {}

    public static CustomerManager getInstance() {
        if (instance == null) {
            instance = new CustomerManager();
        }
        return instance;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(int customerId) {
        customers.removeIf(customer -> customer.getId() == customerId);
    }
}
