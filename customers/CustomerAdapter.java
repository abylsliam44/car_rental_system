package customers;

public class CustomerAdapter implements OldCustomerSystem {
    private Customer newCustomer;

    public CustomerAdapter(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }

    @Override
    public void displayOldCustomerInfo() {
        System.out.println("Customer name: " + newCustomer.getName() + ", type: " + newCustomer.getType());
    }
}

interface OldCustomerSystem {
    void displayOldCustomerInfo();
}
