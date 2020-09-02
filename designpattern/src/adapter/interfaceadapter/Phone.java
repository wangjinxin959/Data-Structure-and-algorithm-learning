package adapter.interfaceadapter;

public class Phone {

    public void charging (Interface in) {
        if (in.output5V() == 5) {
            System.out.println("电压为5V,开始充电");
        } else {
            System.out.println("电压不为5V,不能充电");
        }
    }

}
