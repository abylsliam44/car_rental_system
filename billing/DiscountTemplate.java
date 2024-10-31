package billing;

public abstract class DiscountTemplate {
    // Шаблонный метод
    public final double calculateDiscount(double price, String customerType) {
        if (isEligibleForDiscount(customerType)) {
            return applyDiscount(price);
        } else {
            return price;
        }
    }

    protected abstract boolean isEligibleForDiscount(String customerType);
    protected abstract double applyDiscount(double price);
}

class VIPDiscount extends DiscountTemplate {
    @Override
    protected boolean isEligibleForDiscount(String customerType) {
        return customerType.equalsIgnoreCase("VIP");
    }

    @Override
    protected double applyDiscount(double price) {
        return price * 0.8; // 20% скидка для VIP клиентов
    }
}

class RegularDiscount extends DiscountTemplate {
    @Override
    protected boolean isEligibleForDiscount(String customerType) {
        return customerType.equalsIgnoreCase("Regular");
    }

    @Override
    protected double applyDiscount(double price) {
        return price * 0.9; // 10% скидка для обычных клиентов
    }
}
