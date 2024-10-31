package billing;

public class BillingFacade {
    private DiscountProxy discountProxy;
    private AdditionalServicesDecorator servicesDecorator;

    public BillingFacade() {
        discountProxy = new DiscountProxy();
        servicesDecorator = new AdditionalServicesDecorator();
    }

    // Основной метод для расчета стоимости
    public double calculateTotalPrice(double basePrice, String customerType, boolean hasAdditionalServices) {
        double discountedPrice = discountProxy.applyDiscount(basePrice, customerType);
        if (hasAdditionalServices) {
            discountedPrice = servicesDecorator.addServices(discountedPrice);
        }
        return discountedPrice;
    }
}
