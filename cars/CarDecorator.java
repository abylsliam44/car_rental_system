//Decorator
package cars;

public abstract class CarDecorator extends Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        super(decoratedCar.getModel(), decoratedCar.getColor(), decoratedCar.getEngineType());
        this.decoratedCar = decoratedCar;
    }

    @Override
    public String getModel() {
        return decoratedCar.getModel();
    }

    @Override
    public String getColor() {
        return decoratedCar.getColor();
    }

    @Override
    public String getEngineType() {
        return decoratedCar.getEngineType();
    }

    public abstract double getCost();
}

class GPSDecorator extends CarDecorator {
    public GPSDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public double getCost() {
        return decoratedCar.getCost() + 15; // Adding GPS cost
    }
}

class InsuranceDecorator extends CarDecorator {
    public InsuranceDecorator(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public double getCost() {
        return decoratedCar.getCost() + 50; // Adding insurance cost
    }
}
