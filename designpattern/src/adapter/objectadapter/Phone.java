package adapter.objectadapter;

import adapter.classadapter.Voltage5V;

public class Phone {

    public void charging (Voltage5V voltage) {
        if (voltage.output5V() == 5) {
            System.out.println("电压为5V,开始充电");
        } else {
            System.out.println("电压不为5V,无法充电");
        }
    }

}
