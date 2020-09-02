package factory.traditional.piazzStore.pizza;

public class ToccoPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给ToccoPizza披萨 准备原材料 ");
    }
}
