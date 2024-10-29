package billing;

public abstract class DiscountTemplate {
    public double calculateDiscount(Customer customer) {
        if (isEligibleForDiscount(customer)) {
            return applyDiscount(customer);
        }
        return 0;
    }

    protected abstract boolean isEligibleForDiscount(Customer customer);

    protected abstract double applyDiscount(Customer customer);
}

class VIPDiscount extends DiscountTemplate {
    @Override
    protected boolean isEligibleForDiscount(Customer customer) {
        return customer.isVIP();
    }

    @Override
    protected double applyDiscount(Customer customer) {
        return 100.0; // Flat rate for VIP
    }
}
