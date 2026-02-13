import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
    static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addGroup("Друзья", List.of(
                new Contact("Иван", 123456),
                new Contact("Мария", 234567)
        ));

        phoneBook.addGroup("Работа", List.of(
                new Contact("Анна", 456789),
                new Contact("Сергей", 567890)
        ));

        phoneBook.getGroups().forEach((group, contacts) -> {
            System.out.println(group + ":");
            contacts.forEach(c -> System.out.println("  " + c.name() + ": " + c.phone()));
        });
    }

    private final HashMap<String, List<Contact>> groups = new HashMap<>();

    public void addGroup(String name, List<Contact> contacts) {
        groups.put(name, contacts);
    }

    public HashMap<String, List<Contact>> getGroups() {
        return groups;
    }

    public record Contact(String name, int phone) {
    }
}
