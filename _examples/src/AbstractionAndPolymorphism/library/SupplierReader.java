package AbstractionAndPolymorphism.library;

import AbstractionAndPolymorphism.library.interfaces.Admin;
import AbstractionAndPolymorphism.library.interfaces.BookSupplier;
import AbstractionAndPolymorphism.library.interfaces.Reader;

public class SupplierReader extends User implements BookSupplier, Reader {
    public SupplierReader(String name) {
        super(name);
    }

    @Override
    public void bringBook(String title) {
        System.out.println("Поставщик " + name + " приносит в библиотеку книгу \"" + title + "\"");
    }

    @Override
    public void takeBook(Admin admin, String title) {
        System.out.println("Читатель " + name + " берет у администратора книгу \"" + title + "\"");
    }

    @Override
    public void returnBook(Admin admin, String title) {
        System.out.println("Читатель " + name + " возвращает администратору книгу \"" + title + "\"");
    }
}
