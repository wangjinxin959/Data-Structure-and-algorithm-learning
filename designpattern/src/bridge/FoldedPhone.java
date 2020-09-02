package bridge;

public class FoldedPhone extends Phone{

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void open () {
        System.out.println("折叠");
        super.open();
    }

    public void close () {
        System.out.println("折叠");
        super.close();
    }

    public void call () {
        System.out.println("折叠");
        super.call();
    }

}
