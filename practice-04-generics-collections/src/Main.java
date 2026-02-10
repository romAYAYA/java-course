class Main {
    public static void main(String[] args) {
        testLibrary();
        testBox();
        testStorage();
    }

    private static void testLibrary() {
        System.out.println("=== Тестирование Library ===\n");

        Library library = new Library();

        // Добавление книг
        library.addBook(new Library.Book("1984", "Orwell", 1949));
        library.addBook(new Library.Book("Animal Farm", "Orwell", 1945));
        library.addBook(new Library.Book("Brave New World", "Huxley", 1932));
        library.addBook(new Library.Book("Fahrenheit 451", "Bradbury", 1953));
        library.addBook(new Library.Book("The Martian Chronicles", "Bradbury", 1950));

        // Поиск по автору
        System.out.println("Книги автора Orwell:");
        library.findByAuthor("Orwell").forEach(book ->
                System.out.println("  - " + book.title() + " (" + book.year() + ")")
        );

        System.out.println("\nКниги автора Bradbury:");
        library.findByAuthor("Bradbury").forEach(book ->
                System.out.println("  - " + book.title() + " (" + book.year() + ")")
        );

        // Поиск по году
        System.out.println("\nКниги 1950 года:");
        library.findByYear(1950).forEach(book ->
                System.out.println("  - " + book.title() + " автор " + book.author())
        );

        // Самая новая книга
        System.out.println("\nСамая новая книга: " + library.findNewestBook());

        // Количество книг по авторам
        System.out.println("\nКоличество книг по авторам:");
        library.getBookCountByAuthor().forEach((author, count) ->
                System.out.println("  " + author + ": " + count)
        );

        // Удаление книги
        System.out.println("\nУдаление '1984'...");
        library.removeBook("1984");

        System.out.println("Книги Orwell после удаления:");
        library.findByAuthor("Orwell").forEach(book ->
                System.out.println("  - " + book.title())
        );

        System.out.println("\n");
    }

    private static void testBox() {
        System.out.println("=== Тестирование Box ===\n");

        // String Box
        Box<String> stringBox = new Box<>();
        System.out.println("Пустой: " + stringBox.isEmpty());

        stringBox.put("Привет");
        System.out.println("String box: " + stringBox.get());
        System.out.println("Пустой: " + stringBox.isEmpty());

        // Integer Box
        Box<Integer> intBox = new Box<>();
        intBox.put(42);
        System.out.println("\nInteger box: " + intBox.get());

        // Очистка
        intBox.clear();
        System.out.println("После очистки: " + intBox.get());
        System.out.println("Пустой: " + intBox.isEmpty());

        // Double Box
        Box<Double> doubleBox = new Box<>();
        doubleBox.put(3.14);
        System.out.println("\nDouble box: " + doubleBox.get());

        System.out.println("\n");
    }

    private static void testStorage() {
        System.out.println("=== Тестирование Storage ===\n");

        Storage<String, Integer> ages = new Storage<>();

        // Добавление элементов
        ages.put("Иван", 25);
        ages.put("Мария", 30);
        ages.put("Петр", 35);

        System.out.println("Возраст Ивана: " + ages.get("Иван"));
        System.out.println("Возраст Марии: " + ages.get("Мария"));
        System.out.println("Размер: " + ages.size());

        // Проверка наличия ключа
        System.out.println("\nСодержит 'Иван': " + ages.containsKey("Иван"));
        System.out.println("Содержит 'Анна': " + ages.containsKey("Анна"));

        // Все ключи
        System.out.println("\nВсе ключи: " + ages.getAllKeys());

        // Удаление
        ages.remove("Петр");
        System.out.println("\nПосле удаления 'Петр':");
        System.out.println("Размер: " + ages.size());
        System.out.println("Все ключи: " + ages.getAllKeys());

        // Storage с другими типами
        Storage<Integer, String> names = new Storage<>();
        names.put(1, "Первый");
        names.put(2, "Второй");
        names.put(3, "Третий");

        System.out.println("\nInteger -> String storage:");
        System.out.println("Получить 2: " + names.get(2));
        System.out.println("Все ключи: " + names.getAllKeys());

        System.out.println("\n");
    }
}