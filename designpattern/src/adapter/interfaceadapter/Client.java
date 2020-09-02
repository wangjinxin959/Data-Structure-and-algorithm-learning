package adapter.interfaceadapter;

public class Client {

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new AbsAdapter() {
            @Override
            public int output5V() {
                return 5;
            }
        });
    }

}
