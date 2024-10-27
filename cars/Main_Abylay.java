package cars;


import Database;
public class Main_Abylay {
    public static void main(String[] args) {
        
        Database.initializeCars();
        Database.initializeServices();

        
        CarManager carManager = CarManager.getInstance();

        
        System.out.println("Все автомобили:");
        for (Car car : carManager.getAllCars()) {
            System.out.println(car);
        }

        
        CarFactory suvFactory = new SUVFactory();
        Car newSUV = suvFactory.createCar();
        carManager.addCar(newSUV);

        System.out.println("\nПосле добавления нового автомобиля (SUV):");
        for (Car car : carManager.getAllCars()) {
            System.out.println(car);
        }

        
        CarDecorator gpsCar = new GPSDecorator(newSUV);
        CarDecorator insuredCar = new InsuranceDecorator(gpsCar);

        System.out.println("\nСтоимость автомобиля с услугами GPS и страховка: " + insuredCar.getCost());

        
        System.out.println("\nАвтомобиль после добавления услуг:");
        System.out.println(insuredCar);
    }
}
