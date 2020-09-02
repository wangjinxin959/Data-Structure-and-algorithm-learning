package factory.factorymethod.piazzStore.order;


import factory.factorymethod.piazzStore.pizza.*;

public class LDOrderPizza extends OrderPizza{

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
