public class CustomerFactory {
    public Customer createPrivateCustomer(String name, String phone) {
        return new Customer(name, phone, "private");
    }

    public Customer createCorporateCustomer(String name, String phone) {
        return new Customer(name, phone, "corporate");
    }

    public Customer createVIPCustomer(String name, String phone) {
        return new Customer(name, phone, "VIP");
    }
}
