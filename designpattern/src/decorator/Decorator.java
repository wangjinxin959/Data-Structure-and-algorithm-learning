package decorator;

public class Decorator extends Drink {

    private Drink drink;

    public Decorator (Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost() + getPrice();
    }

    @Override
    public String getDesc() {
        return desc + "+" + drink.getDesc();
    }
}
