package factory.absfactory.piazzStore.order;

import factory.absfactory.piazzStore.pizza.Pizza;

public interface AbsFactory {

    Pizza createPizza(String type);

}
