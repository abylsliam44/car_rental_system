package billing;

class BasicCar implements Car {
    @Override
    public double getCost() {
        return 200.0; // Basic car rental price
    }

    @Override
    public String getDescription() {
        return "Basic Car";
    }
}

abstract class AdditionalServicesDecorator implements Car {
    protected Car car;

    public AdditionalServicesDecorator(Car car) {
        this.car = car;
    }

    public abstract double getCost();

    public abstract String getDescription();
}

class InsuranceDecorator extends AdditionalServicesDecorator {
    public InsuranceDecorator(Car car) {
        super(car);
    }

    @Override
    public double getCost() {
        return car.getCost() + 50.0; // Insurance cost
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Insurance";
    }
}
