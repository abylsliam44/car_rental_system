package customers;

public class CustomerProxy implements CustomerService {
    private RealCustomerService realCustomerService;
    private boolean isAuthorized;

    public CustomerProxy(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        this.realCustomerService = new RealCustomerService();
    }

    @Override
    public void accessCustomerData() {
        if (isAuthorized) {
            realCustomerService.accessCustomerData();
        } else {
            System.out.println("Access denied: unauthorized user.");
        }
    }
}

interface CustomerService {
    void accessCustomerData();
}

class RealCustomerService implements CustomerService {
    @Override
    public void accessCustomerData() {
        System.out.println("Accessing customer data...");
    }
}
