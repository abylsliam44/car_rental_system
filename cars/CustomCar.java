package cars;

public class CustomCar extends BasicCar {
    private boolean hasAirConditioning;
    private boolean hasGPS;

    public CustomCar(String model, String brand, boolean hasAirConditioning, boolean hasGPS) {
        super(model, brand);
        this.hasAirConditioning = hasAirConditioning;
        this.hasGPS = hasGPS;
    }

    @Override
    public void assemble() {
        super.assemble();
        if (hasAirConditioning) {
            System.out.println("Adding Air Conditioning");
        }
        if (hasGPS) {
            System.out.println("Adding GPS");
        }
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    public boolean hasGPS() {
        return hasGPS;
    }
}
