public class CustomerBuilder {
    private String name;
    private String phone;
    private String type;

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CustomerBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CustomerBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Customer build() {
        return new Customer(name, phone, type);
    }
}
