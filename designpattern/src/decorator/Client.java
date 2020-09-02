package decorator;

import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {
        Drink order = new DeCaf();
        double price = order.cost();
        System.out.println(order.getDesc()+price+"元");

        order = new Milk(order);
        System.out.println(order.getDesc()+order.cost()+"元");

        order = new Soy(order);
        System.out.println(order.getDesc()+order.cost()+"元");

        new BufferedReader(new InputStreamReader(new FileInputStream("")));
        new PrintWriter(new FileOutputStream(""));
    }

}
