package adapter.objectadapter;

import adapter.classadapter.Voltage5V;

public class VoltageAdapter implements Voltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter (Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        if (voltage220V != null) {
            int src = voltage220V.output220V();
            System.out.println("使用适配器适配");
            int dest = src / 44;
            return dest;
        }
        return 0;
    }
}
