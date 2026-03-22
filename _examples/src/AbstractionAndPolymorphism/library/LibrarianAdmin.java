package AbstractionAndPolymorphism.library;

import AbstractionAndPolymorphism.library.interfaces.Admin;
import AbstractionAndPolymorphism.library.interfaces.BookSupplier;
import AbstractionAndPolymorphism.library.interfaces.Librarian;
import AbstractionAndPolymorphism.library.interfaces.Reader;

public class LibrarianAdmin extends User implements Librarian, Admin {
    public LibrarianAdmin(String name) {
        super(name);
    }

    @Override
    public void orderBook(BookSupplier supplier, String title) {
        System.out.println("Библиотекарь " + name + " заказывает у поставщика книгу \"" + title + "\"");
        supplier.bringBook(title);
    }

    @Override
    public void findBook(String title) {
        System.out.println("Администратор " + name + " находит книгу \"" + title + "\"");
    }

    @Override
    public void overdueNotification(Reader reader) {
        System.out.println("Администратор " + name + " уведомляет читателя о просрочке возврата книги");
    }
}
