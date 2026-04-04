package interfaces.flying;

public class Duck implements Flyable, Waterfowl {
    @Override
    public void fly() {
        System.out.println("лечу над камышами");
    }

    @Override
    public void land() {
        System.out.println("приземляюсь");
    }

    @Override
    public void swim() {
        System.out.println("плаваю");
    }
}
