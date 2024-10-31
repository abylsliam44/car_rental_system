package cars;

public abstract class CarPrototype implements Cloneable {
    protected String model;
    protected String brand;

    public CarPrototype(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public CarPrototype clone() throws CloneNotSupportedException {
        return (CarPrototype) super.clone();
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }
}

class LuxuryCarPrototype extends CarPrototype {
    public LuxuryCarPrototype(String model, String brand) {
        super(model, brand);
    }
}
