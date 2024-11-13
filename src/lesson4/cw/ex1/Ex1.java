package lesson4.cw.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Создайте коллекцию мужских и женских имён с помощью интерфейса List
    1. Отсортируйте коллекцию в алфавитном порядке
    2. Отсортируйте коллекцию по количчеству букв в слове
    3. Разверните коллекцию
 */
public class Ex1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Vasya", "Oleg", "Egor", "Kostya", "Lera", "Sergey", "Olya", "Vika", "A"));
        Collections.sort(names);
        System.out.println("1. " + names);
        names.sort(new NameLengthComparator());
//        names.sort(Comparator.comparing(String::length));
        System.out.println("2. " + names);
        Collections.reverse(names);
        System.out.println("3. " + names);
    }
}
