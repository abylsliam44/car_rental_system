package cars;

public class CarBuilder {
    private String model;
    private String brand;
    private boolean hasAirConditioning;
    private boolean hasGPS;

    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public CarBuilder setAirConditioning(boolean hasAirConditioning) {
        this.hasAirConditioning = hasAirConditioning;
        return this;
    }

    public CarBuilder setGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
        return this;
    }

    public Car build() {
        return new CustomCar(model, brand, hasAirConditioning, hasGPS);
    }
}
