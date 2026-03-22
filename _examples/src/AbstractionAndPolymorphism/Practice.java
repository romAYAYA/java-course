package AbstractionAndPolymorphism;

import AbstractionAndPolymorphism.amphibians.Frog;
import AbstractionAndPolymorphism.amphibians.Toad;
import AbstractionAndPolymorphism.figures.Circle;

public class Practice {
    void main() {
        Circle circle = new Circle();
        System.out.println(circle.getArea());

        Frog frog = new Frog();
        System.out.println("green frog");
        frog.move();

        Toad toad = new Toad();
        System.out.println("brown toad");
        toad.move();


    }
}
