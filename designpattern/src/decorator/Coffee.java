package decorator;

public class Coffee extends Drink {
    @Override
    public double cost() {
        return getPrice();
    }
}
