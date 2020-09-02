package bridge;

public class Client {

    public static void main(String[] args) {
        Phone phone = new UpRightPhone(new XiaoMi());
        phone.open();
        phone.call();
        phone.close();
    }

}
