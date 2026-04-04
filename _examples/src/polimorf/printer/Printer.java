package polimorf.printer;

public class Printer {
    public void print(int i) {
        System.out.println(i + " - это число.");
    }

    public void print(String s) {
        System.out.println(s + " - это строка.");
    }

    public void print(Object o) {
        System.out.println(o.toString() + " - это объект.");
    }

    @Override
    public String toString() {
        return "Я - объект принтера!";
    }
}

