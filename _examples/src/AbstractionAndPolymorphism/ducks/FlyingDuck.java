package AbstractionAndPolymorphism.ducks;

public class FlyingDuck extends Duck {

    public void fly() {
        System.out.println("Лечу куда хочу.");
    }

    public void eat() {
        System.out.println("Обычно кушаю разные семена, но иногда нахожу хлебушек.");
    }

    @Override
    public String getName() {
        return "Я - обычная утка. Кря!";
    }
}