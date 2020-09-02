package builder;

public class Client {

    public static void main(String[] args) {
        AbstractHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }

}
