package factory.simplefactory.pizzaStore.order;

import factory.simplefactory.pizzaStore.pizza.*;

public class SimpleFactory {

    public static Pizza createPizza (String type) {
        Pizza pizza = null;
            if ("greek".equals(type)){
                pizza = new GreekPizza();
                pizza.setName("希腊披萨");
            } else if ("cheese".equals(type)) {
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
            } else if ("pepper".equals(type)) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            } else if ("tocco".equals(type)) {
                pizza = new ToccoPizza();
                pizza.setName("tocco");
            }
        return pizza;
    }

}
