package interfaces.zoo;

public class Cat implements Pet, Mammal {
    @Override
    public void eat() {
        System.out.println("cat eating");
    }

    @Override
    public void playWithToy() {
        System.out.println("cat playing with a toy");
    }

    @Override
    public void feedWithMilk() {
        System.out.println("cat is feeding with milk");
    }
}
