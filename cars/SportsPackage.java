package cars;

public class SportsPackage extends CarDecorator {
    public SportsPackage(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Package");
    }
}
