package factory.factorymethod.piazzStore.order;


import factory.factorymethod.piazzStore.pizza.BJCheesePizza;
import factory.factorymethod.piazzStore.pizza.BJGreekPizza;
import factory.factorymethod.piazzStore.pizza.Pizza;

public class BJOrderPizza  extends OrderPizza{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new BJCheesePizza();
            pizza.setName("BJ奶酪");
        } else if ("greek".equals(type)) {
            pizza = new BJGreekPizza();
            pizza.setName("BJ希腊");
        }
        return pizza;
    }

}
