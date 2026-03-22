package AbstractionAndPolymorphism.library.interfaces;

public interface Admin {
    void findBook(String title);
    void overdueNotification(Reader reader);
}
