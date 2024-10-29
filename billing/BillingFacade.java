package billing;

public class BillingFacade {
    private DiscountTemplate discount;
    private AdditionalServicesDecorator services;

    public BillingFacade(DiscountTemplate discount, AdditionalServicesDecorator services) {
        this.discount = discount;
        this.services = services;
    }

    public double calculateFinalBill(int carId, int customerId, int days) {
        double baseCost = getRentalCost(carId, days);
        double discountAmount = discount.calculateDiscount(getCustomer(customerId));
        double serviceCost = services.getCost();
        return baseCost - discountAmount + serviceCost;
    }

    private double getRentalCost(int carId, int days) {
        // Assume a basic calculation based on days
        return days * 50.0; // Example rate
    }

    private Customer getCustomer(int customerId) {
        // Retrieve customer details
        return new Customer(customerId);
    }
}
