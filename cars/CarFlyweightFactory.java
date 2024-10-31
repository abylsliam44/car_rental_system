package cars;

import java.util.HashMap;
import java.util.Map;

public class CarFlyweightFactory {
    private static Map<String, Car> carPool = new HashMap<>();

    public static Car getCar(String model, String brand) {
        String key = model + "-" + brand;
        Car car = carPool.get(key);
        if (car == null) {
            car = new BasicCar(model, brand);
            carPool.put(key, car);
        }
        return car;
    }
}
