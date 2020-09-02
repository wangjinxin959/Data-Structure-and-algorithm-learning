package factory.absfactory.piazzStore.order;

import factory.absfactory.piazzStore.pizza.*;

public class BJFactory implements AbsFactory{
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
