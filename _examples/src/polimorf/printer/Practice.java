package polimorf.printer;

public class Practice {
    public static void main(String[] args) {
        Printer printer = new Printer();
        // Будет выбран метод, принимающий тип int
        printer.print(10);
        // Будет выбран метод, принимающий тип String
        printer.print("Привет!");
        printer.print(100L);
        // Будет выбран метод, принимающий тип Object
        printer.print(printer);
    }
}
