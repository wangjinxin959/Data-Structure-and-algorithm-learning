package builder.improve;

public abstract class Builder {

    Product product = new Product();

    public abstract void builderBasics();

    public abstract void builderWalls();

    public abstract void roofed();

    public Product getResult () {
        return product;
    }


}
