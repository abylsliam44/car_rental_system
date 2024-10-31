package billing;

public class AdditionalServicesDecorator {
    // Метод для добавления услуг
    public double addServices(double price) {
        return price + 100; // Дополнительные услуги стоят 100
    }
}
