package interfaces.flying;

public class Seagull implements Flyable, Waterfowl, Hunter {
    @Override
    public void fly() {
        System.out.println("парю над морем");
    }

    @Override
    public void land() {
        System.out.println("мягкая посадка");
    }

    @Override
    public void swim() {
        System.out.println("качаюсь на волнах");
    }

    @Override
    public void hunt() {
        System.out.println("ловлю рыбку");
    }
}
