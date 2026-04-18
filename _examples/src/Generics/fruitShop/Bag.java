package Generics.fruitShop;

import java.util.ArrayList;
import java.util.List;

public class Bag<T extends Fruit> {
    private final List<T> purchase = new ArrayList<>();

    public void addFruit(T fruit) {
        purchase.add(fruit);
    }

    public void printPurchase() {
        if (!purchase.isEmpty()) {
            double sum = 0;
            for (T fruit : purchase) {
                sum += fruit.getPrice();
            }
            System.out.println("Ваша покупка: пакетик с фруктами - " + purchase.get(0).getName());
            System.out.printf("Стоимость вашей покупки составит %.2f", sum);
        }
    }
}

