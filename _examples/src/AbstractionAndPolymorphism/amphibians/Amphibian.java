package AbstractionAndPolymorphism.amphibians;

public abstract class Amphibian {
    protected String color;

    protected Amphibian(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public void eat() {
        System.out.println("eat insects");
    }

    public abstract void move();
}
