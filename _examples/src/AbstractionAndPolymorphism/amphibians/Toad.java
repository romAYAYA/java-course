package AbstractionAndPolymorphism.amphibians;

public class Toad extends Amphibian {
    public Toad() {
        super("brown");
    }

    @Override
    public void move() {
        System.out.println("я важно хожу");
    }

    @Override
    public String getColor() {
        return color;
    }
}
