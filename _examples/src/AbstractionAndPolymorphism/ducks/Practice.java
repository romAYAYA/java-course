package AbstractionAndPolymorphism.ducks;

public class Practice {
    public static void main(String[] args) {
        FlyingDuck flyingDuck = new FlyingDuck();
        RubberDuck rubberDuck = new RubberDuck();

        System.out.println("Сначала о себе расскажет обычная уточка:");
        System.out.println(flyingDuck.getName());
        flyingDuck.swim();
        flyingDuck.fly();
        flyingDuck.eat();
        flyingDuck.quack();

        System.out.println("А теперь - резиновая:");
        System.out.println(rubberDuck.getName());
        rubberDuck.swim();
        rubberDuck.quack();
    }
}