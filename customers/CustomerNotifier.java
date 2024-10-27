public class CustomerNotifier {
    private List<Customer> customers = new ArrayList<>();

    public void subscribe(Customer customer) {
        customers.add(customer);
    }

    public void unsubscribe(Customer customer) {
        customers.remove(customer);
    }

    public void notifyAllCustomers(String message) {
        for (Customer customer : customers) {
            customer.receiveNotification(message);
        }
    }
}
