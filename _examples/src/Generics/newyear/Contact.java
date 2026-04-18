package Generics.newyear;

public abstract class Contact {
    private final String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage() {
        System.out.println("default message");
    }

    public void print() {
        System.out.println("default print");
    }
}
