package cars;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();
    private static CarManager instance;

    private CarManager() {}

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByModel(String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null; // Если автомобиль не найден
    }
}
