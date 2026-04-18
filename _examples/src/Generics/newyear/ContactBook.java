package Generics.newyear;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactBook<T extends Contact> {
    public List<T> contacts = new ArrayList<>();

    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void printList() {
        for (var contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }
    }

    public void congratulate(String name) {
        boolean contactPresented = false;

        for (var contact : contacts) {
            if (Objects.equals(contact.getName().trim().toLowerCase(), name.trim().toLowerCase())) {
                contactPresented = true;
                System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
                contact.sendMessage();
            }
        }

        if (!contactPresented) {
            System.out.println("Не найден контакт с указанным именем.");
        }
    }
}