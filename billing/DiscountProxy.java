package billing;

public class DiscountProxy {
    private DiscountTemplate discountTemplate;

    public DiscountProxy(DiscountTemplate discountTemplate) {
        this.discountTemplate = discountTemplate;
    }

    public double getDiscount(Customer customer) {
        if (customer.hasActiveMembership()) {
            return discountTemplate.calculateDiscount(customer);
        }
        return 0;
    }
}
