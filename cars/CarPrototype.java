//Prototype
package cars;

public class CarPrototype implements Cloneable {
    private String model;
    private String color;
    private String engineType;

    public CarPrototype(String model, String color, String engineType) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public CarPrototype clone() {
        try {
            return (CarPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for this object", e);
        }
    }
}
