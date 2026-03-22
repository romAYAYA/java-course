package AbstractionAndPolymorphism.library;

public class Practice {
     void main() {
        var petya = new SupplierReader("Петя");
        var vasya = new LibrarianAdmin("Вася");
        var masha = new SimpleReader("Маша");

        vasya.orderBook(petya, "Игра престолов");

        vasya.findBook("Война и мир");
        masha.takeBook(vasya, "Война и мир");

        vasya.overdueNotification(masha);
        masha.returnBook(vasya, "Война и мир");

        petya.takeBook(vasya, "Мастер и Маргарита");
        petya.returnBook(vasya, "Мастер и Маргарита");
    }
}
