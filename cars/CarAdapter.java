package cars;

public class CarAdapter implements OldCarSystem {
    private Car newCar;

    public CarAdapter(Car newCar) {
        this.newCar = newCar;
    }

    @Override
    public void displayOldCarInfo() {
        System.out.println("Car model: " + newCar.getModel() + ", brand: " + newCar.getBrand());
    }
}

interface OldCarSystem {
    void displayOldCarInfo();
}
