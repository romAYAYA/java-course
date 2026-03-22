package AbstractionAndPolymorphism.library.interfaces;

public interface Reader {
    void takeBook(Admin admin, String title);
    void returnBook(Admin admin, String title);
}
