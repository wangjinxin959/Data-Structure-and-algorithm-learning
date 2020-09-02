package builder;

/**
 * 这样设计产品和创建产品的流程封装在了一起 增强了耦合
 */
public abstract class AbstractHouse {

    public abstract void buildBasic(); //打地基

    public abstract void buildWalls(); // 刷墙

    public abstract void roofed(); //封顶

    public void build () {
        buildBasic();
        buildWalls();
        roofed();
    }

}
