package cars;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;               
    private String model;
    private String color;
    private String engineType;
    private double baseCost;
    private List<String> additionalServices;

    
    public Car(int id, String model, String color, String engineType) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.engineType = engineType;
        this.baseCost = 100.0; 
        this.additionalServices = new ArrayList<>();
    }

    
    public Car(String model, String color, String engineType) {
        this.model = model;
        this.color = color;
        this.engineType = engineType;
        this.baseCost = 100.0;
        this.additionalServices = new ArrayList<>();
    }

    
    public int getId() {
        return id;
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

    public double getCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public List<String> getAdditionalServices() {
        return additionalServices;
    }

    public void addService(String service) {
        additionalServices.add(service);
    }

    public double calculateTotalCost() {
        double totalCost = baseCost;
        for (String service : additionalServices) {
            switch (service.toLowerCase()) {
                case "gps":
                    totalCost += 15.0;
                    break;
                case "insurance":
                    totalCost += 50.0;
                    break;
                case "premium seats":
                    totalCost += 25.0;
                    break;
            }
        }
        return totalCost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engineType='" + engineType + '\'' +
                ", baseCost=" + baseCost +
                ", additionalServices=" + additionalServices +
                '}';
    }
}
