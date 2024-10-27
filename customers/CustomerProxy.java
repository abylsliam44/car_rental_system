public class CustomerProxy {
    private CustomerManager customerManager = CustomerManager.getInstance();

    public Customer getCustomerById(int id) {
        // Add access control logic here if necessary
        return customerManager.getAllCustomers().stream()
                .filter(customer -> customer.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
