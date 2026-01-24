public class Hamster {
      String name;
     int age;
     int weight;
      String color;

    Hamster(String name, int age, int weight, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    Hamster() {
        this.name = "";
        this.age = 0;
        this.weight = 0;
        this.color = "";
    }

    @Override
    public String toString() {
        return String.format("Hamster{name=%s, age=%d, weight=%d, color=%s}", name, age, weight, color);
    }
}

//public record Hamster(String name, int age, int weight, String color) {}