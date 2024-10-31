package customers;

public abstract class Customer {
    protected String name;
    protected String type;

    public Customer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

class VipCustomer extends Customer {
    public VipCustomer(String name, String type) {
        super(name, type);
    }
}

class RegularCustomer extends Customer {
    public RegularCustomer(String name, String type) {
        super(name, type);
    }
}

class CustomCustomer extends Customer {
    public CustomCustomer(String name, String type, boolean hasLoyaltyCard, boolean receivesNewsletter) {
        super(name, type);
    }
}
