package builder.improve;

public class Director {

    private Builder builder;

    public Director (Builder builder) {
        this.builder = builder;
    }

    public Product getResult () {
        builder.builderBasics();
        builder.builderWalls();
        builder.roofed();
        return builder.getResult();
    }

}
