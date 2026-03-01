package Object;

public class Main {

    private static LostAndFoundOffice<Object> lostAndFound;

    static void main() {
//        Person[] people = {new Person("Томирис"), new Person("Дамир")};
//        int peopleCount = sizeOf(people);
//        System.out.println("В массиве people " + peopleCount + " элемента.");
//
//        String[] names = {"Максим", "Абай", "Тамерлан", "Александр"};
//        int namesCount = sizeOf(names);
//        System.out.println("В массиве names " + namesCount + " элемента.");
//
//        Integer[] numbers = {42, 24, 45, 34, 23, 43, 54, 65, 43};
//        int numbersCount = sizeOf(numbers);
//        System.out.println("В массиве numbers " + numbersCount + " элементов.");

//
//        lostAndFound = new LostAndFoundOffice<>();
//
//        Ball ball = new Ball();
//        Accordion accordion = new Accordion();
//        Umbrella umbrella = new Umbrella();
//        Hat hat = new Hat();
//
//        lostAndFound.put(ball);
//        lostAndFound.put(accordion);
//        lostAndFound.put(umbrella);
//
//        checkObject(accordion, "Аккордеон");
//        checkObject(ball, "Мяч");
//        checkObject(umbrella, "Зонт");
//        checkObject(hat, "Шляпа");

//        int variable1 = 42;
//        int variable2 = 42;
//
//        boolean result = variable1 == variable2; // сравниваем значения переменных
//        System.out.println(result); // значения равны
//
//        String title = "Java для начинающих";
//        String author = "Ансар Сеньёров";
//        int pagesNumber = 777;
//
//        // передаём одни и те же данные двум объектам
//        Book book1 = new Book(title, author, pagesNumber);
//        Book book2 = new Book(title, author, pagesNumber);
//
////        boolean result2 = book1 == book2; // сравниваем значения объектных переменных
//        boolean result2 = book1.equals(book2);
//        System.out.println(result2); // получили некорректный результат

        Song theRockBandSong = new Song("Popular Song", "The Rock Band", "John Doe");
        Song johnDoeSong = new Song("Popular Song", "The Rock Band", "John Doe");

        Song rapSong = new Song("A song about a hard life", "Popular Rapper", "Popular Rapper");

        Song richardRoeSong = new Song("A song about a hard life", "Popular Rapper", "Richard Roe");

        // проверяем рефлексивность
        boolean check0 = false;
        if (johnDoeSong.equals(johnDoeSong)) {
            check0 = true;
        }

        // проверяем симметричность
        boolean check1 = false;
        if (theRockBandSong.equals(johnDoeSong) &&
                johnDoeSong.equals((Object) theRockBandSong)) {
            check1 = true;
        }

        // проверяем на неравенство объекту другого класса
        boolean check2 = false;
        if (!rapSong.equals(42)) {
            check2 = true;
        }

        // проверяем на неравенство пустой ссылке
        boolean check3 = false;
        if (!theRockBandSong.equals(null)) {
            check3 = true;
        }

        // проверяем на правильное сравнение объектов одного класса
        boolean check4 = true;
        if (richardRoeSong.equals(johnDoeSong)) {
            check4 = false;
        }

        // проверяем транзитивность
        boolean check5 = false;
        Song popularSong = new Song("Popular Song", "The Rock Band", "John Doe");
        if (popularSong.equals(theRockBandSong) && theRockBandSong.equals(johnDoeSong)
                && popularSong.equals(johnDoeSong)) {
            check5 = true;
        }

        // проверяем согласованность
        boolean check6 = true;
        boolean result = rapSong.equals(richardRoeSong);
        for (int i = 0; i < 10; i++) {
            if (rapSong.equals(richardRoeSong) != result) {
                check6 = false;
            }
        }

        if (check0 && check1 && check2 &&
                check3 && check4 && check5 && check6) {
            System.out.println("Поздравляем! Метод equals реализован верно.");
        } else {
            System.out.println("Что-то здесь не так. Подумайте над реализацией ещё немного.");
        }

    }
//
//    private static void checkObject(Object object, String description) {
//        if (lostAndFound.check(object)) {
//            System.out.println('\'' + description + "' нашёлся!");
//        } else {
//            System.out.println('\'' + description + "' в бюро находок никто не приносил :(");
//        }
//    }

//    public static int sizeOf(Object[] array) { // параметр - массив элементов типа Object)
//        int count = 0;
//        for (Object o : array) {
//            count++;
//        }
//        return count;
//    }
//}
}

