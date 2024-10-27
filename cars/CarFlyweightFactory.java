//Flyweight
package cars;

import java.util.HashMap;
import java.util.Map;

public class CarFlyweightFactory {
    private static final Map<String, Car> carPool = new HashMap<>();

    public static Car getCar(String model, String color, String engineType) {
        String key = model + "_" + color + "_" + engineType;
        Car car = carPool.get(key);

        if (car == null) {
            car = new Car(model, color, engineType);
            carPool.put(key, car);
        }

        return car;
    }
}
