package AbstractionAndPolymorphism.ducks;

public abstract class Duck {
    public abstract String getName();

    public void swim() {
        System.out.println("Да, я умею плавать!");
    }

    public void quack() {
        System.out.println("Кря!");
    }
}
