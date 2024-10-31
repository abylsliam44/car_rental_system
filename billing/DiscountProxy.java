package billing;

public class DiscountProxy {
    private DiscountTemplate vipDiscount;
    private DiscountTemplate regularDiscount;

    public DiscountProxy() {
        vipDiscount = new VIPDiscount();
        regularDiscount = new RegularDiscount();
    }

    public double applyDiscount(double basePrice, String customerType) {
        if (customerType.equalsIgnoreCase("VIP")) {
            return vipDiscount.calculateDiscount(basePrice, customerType);
        } else {
            return regularDiscount.calculateDiscount(basePrice, customerType);
        }
    }
}
