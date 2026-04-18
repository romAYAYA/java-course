package Generics.fruitShop;

public abstract class Fruit {
    private final String name;
    private final Double price;

    protected Fruit(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
