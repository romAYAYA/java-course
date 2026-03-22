package AbstractionAndPolymorphism.library;

import AbstractionAndPolymorphism.library.interfaces.Admin;
import AbstractionAndPolymorphism.library.interfaces.Reader;

public class SimpleReader extends User implements Reader {
    public SimpleReader(String name) {
        super(name);
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
