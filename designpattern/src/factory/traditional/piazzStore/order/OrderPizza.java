package factory.traditional.piazzStore.order;

import factory.traditional.piazzStore.pizza.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    public OrderPizza () {
        Pizza pizza = null;
        String type = "";
        do {
            type = getType();
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
            } else{
                System.out.println("没有此种类披萨!");
                break;
            }

            pizza.prepare();
            pizza.cut();
            pizza.bake();
            pizza.box();

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
