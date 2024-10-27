//Factory
package cars;

public abstract class CarFactory {
    public abstract Car createCar();

    public static CarFactory getFactory(String type) {
        switch (type.toLowerCase()) {
            case "suv":
                return new SUVFactory();
            case "sedan":
                return new SedanFactory();
            case "electric":
                return new ElectricCarFactory();
            default:
                throw new IllegalArgumentException("Unknown car type");
        }
    }
}

class SUVFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new Car("SUV", "White", "V6 Engine");
    }
}

class SedanFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new Car("Sedan", "Black", "V4 Engine");
    }
}

class ElectricCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new Car("Electric", "Blue", "Electric Engine");
    }
}
