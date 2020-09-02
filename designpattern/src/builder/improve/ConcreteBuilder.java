package builder.improve;

public class ConcreteBuilder extends Builder{
    @Override
    public void builderBasics() {
        System.out.println("别墅打地基");
    }

    @Override
    public void builderWalls() {
        System.out.println("别墅刷墙");
    }

    @Override
    public void roofed() {
        System.out.println("封顶");
    }

}
