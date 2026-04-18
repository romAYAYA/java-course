package Generics.printer;

import java.util.List;

public class Printer<T extends Number> {
    private final List<T> list;

    public Printer(List<T> list) {
        this.list = list;
    }

    public void print() {
        for (T t : list) {
            double price = t.doubleValue() / 100;
            System.out.println("Цена товара: " + price + " $.");
        }
    }
}