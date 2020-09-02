package factory.absfactory.piazzStore.order;

import factory.absfactory.piazzStore.pizza.LDCheesePizza;
import factory.absfactory.piazzStore.pizza.LDGreekPizza;
import factory.absfactory.piazzStore.pizza.Pizza;

public class LDFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new LDCheesePizza();
            pizza.setName("LD奶酪");
        } else if ("greek".equals(type)) {
            pizza = new LDGreekPizza();
            pizza.setName("LD希腊");
        }
        return pizza;
    }
}
