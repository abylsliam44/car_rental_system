package cars;

public abstract class CarFactory {
    public abstract Car createCar(String model, String brand);

    public static CarFactory getFactory(String type) {
        if (type.equalsIgnoreCase("Luxury")) {
            return new LuxuryCarFactory();
        } else {
            return new BasicCarFactory();
        }
    }
}

class LuxuryCarFactory extends CarFactory {
    @Override
    public Car createCar(String model, String brand) {
        return new LuxuryCar(model, brand);
    }
}

class BasicCarFactory extends CarFactory {
    @Override
    public Car createCar(String model, String brand) {
        return new BasicCar(model, brand);
    }
}
