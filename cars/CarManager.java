//Singleton
package cars;

import java.util.List;
import java.util.ArrayList;

public class CarManager {
    private static CarManager instance;
    private List<Car> cars;

    private CarManager() {
        cars = new ArrayList<>();
    }

    public static CarManager getInstance() {
        if (instance == null) {
            instance = new CarManager();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(int carId) {
        cars.removeIf(car -> car.getId() == carId);
    }

    public Car getCarById(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
