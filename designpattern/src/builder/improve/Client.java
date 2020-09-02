package builder.improve;

public class Client {

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product result = director.getResult();
        System.out.println(result);
    }

}
