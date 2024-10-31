package cars;

public interface Car {
    void assemble();
    String getModel();
    String getBrand();
}

class BasicCar implements Car {
    private String model;
    private String brand;

    public BasicCar(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a basic car.");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getBrand() {
        return brand;
    }
}

class LuxuryCar extends BasicCar {
    public LuxuryCar(String model, String brand) {
        super(model, brand);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a luxury car.");
    }
}
