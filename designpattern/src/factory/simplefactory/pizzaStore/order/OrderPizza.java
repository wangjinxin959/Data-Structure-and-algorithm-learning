package factory.simplefactory.pizzaStore.order;


import factory.simplefactory.pizzaStore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    Pizza pizza = null;
    String type = "";
    public OrderPizza () {
        do {
            type = getType();
            pizza = SimpleFactory.createPizza(type);
            if (pizza != null) {
                pizza.prepare();
                pizza.cut();
                pizza.bake();
                pizza.box();
            } else {
                break;
            }
        }while (true);
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
