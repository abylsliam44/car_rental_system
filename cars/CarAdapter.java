//Adapter
package cars;

public class CarAdapter {
    private ExternalCarSystem externalCarSystem;

    public CarAdapter(ExternalCarSystem externalCarSystem) {
        this.externalCarSystem = externalCarSystem;
    }

    public String adaptCarData(Car car) {
        return externalCarSystem.receiveCarData(
                car.getModel(),
                car.getColor(),
                car.getEngineType(),
                car.getCost()
        );
    }
}

class ExternalCarSystem {
    public String receiveCarData(String model, String color, String engineType, double cost) {
        return "Car details - Model: " + model + ", Color: " + color + ", Engine: " + engineType + ", Cost: $" + cost;
    }
}
