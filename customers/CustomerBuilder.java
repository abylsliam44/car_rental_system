package customers;

public class CustomerBuilder {
    private String name;
    private String type;
    private boolean hasLoyaltyCard;
    private boolean receivesNewsletter;

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public CustomerBuilder setLoyaltyCard(boolean hasLoyaltyCard) {
        this.hasLoyaltyCard = hasLoyaltyCard;
        return this;
    }

    public CustomerBuilder setReceivesNewsletter(boolean receivesNewsletter) {
        this.receivesNewsletter = receivesNewsletter;
        return this;
    }

    public Customer build() {
        return new CustomCustomer(name, type, hasLoyaltyCard, receivesNewsletter);
    }
}
