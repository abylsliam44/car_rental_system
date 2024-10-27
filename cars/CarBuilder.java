//Builder
package cars;

public class CarBuilder {
    private String model;
    private String color;
    private String engineType;

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder setEngineType(String engineType) {
        this.engineType = engineType;
        return this;
    }

    public Car build() {
        return new Car(model, color, engineType);
    }
}
