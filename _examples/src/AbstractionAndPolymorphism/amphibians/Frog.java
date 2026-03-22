package AbstractionAndPolymorphism.amphibians;

public class Frog extends Amphibian {
    public Frog() {
        super("green");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void move() {
        System.out.println("передвигаюсь прыжками по суше");
    }
}
