package Generics.printer;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        // Первый магазин продает дорогие товары и хочет передавать цент с типом Long
        List<Long> longList = new ArrayList<>();
        longList.add(Long.MAX_VALUE);

        Printer<Long> longPrinter = new Printer<>(longList);
        longPrinter.print();

        // Второй магазин продает товары подешевле и использует для передачи цент с типом Integer
        List<Integer> intList = new ArrayList<>();
        intList.add(100000);

        Printer<Integer> integerPrinter = new Printer<>(intList);
        integerPrinter.print();

        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");

        // Этот вариант должен вызывать ошибку компиляции
//         Printer<String> stringPrinter = new Printer<>(stringList);
//         stringPrinter.print();
    }
}

//class Merger<T1 extends Number, T2 extends T1> {
//    public void merge(List<T1> list1, List<T2> list2, int max) {
//        for (int i = 0; i < max - list1.size(); i++) {
//            list1.add(list2.get(i));
//        }
//    }
//}