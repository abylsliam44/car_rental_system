
package customers;

public abstract class CustomerFactory {
    public abstract Customer createCustomer(String name, String type);

    public static CustomerFactory getFactory(String type) {
        if (type.equalsIgnoreCase("VIP")) {
            return new VIPCustomerFactory();
        } else {
            return new RegularCustomerFactory();
        }
    }
}

class VIPCustomerFactory extends CustomerFactory {
    @Override
    public Customer createCustomer(String name, String type) {
        return new VIPCustomer(name, type);
    }
}

class RegularCustomerFactory extends CustomerFactory {
    @Override
    public Customer createCustomer(String name, String type) {
        return new RegularCustomer(name, type);
    }
}
