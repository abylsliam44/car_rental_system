package cars;

public abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public void assemble() {
        decoratedCar.assemble();
    }

    @Override
    public String getModel() {
        return decoratedCar.getModel();
    }

    @Override
    public String getBrand() {
        return decoratedCar.getBrand();
    }
}


