package lesson4.cw.ex2;

import java.util.*;

/*
    В рамках выполнения задачи необходимо:
    Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
    Получите уникальный список Set на основании List
    Определите наименьший элемент (алфавитный порядок)
    Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
    Удалите все элементы содержащие букву ‘A’
 */
public class Ex2 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Vasya", "Oleg", "Egor", "Konstantin", "Lera", "Sergey", "Olya", "Vika", "Alex", "Egor", "Lera"));
        Set<String> namesSet = listToSet(names);
        System.out.println("1. " + namesSet);
        System.out.println("2. " + getMinAlpha(namesSet));
        System.out.println("3. " + getMaxLength(namesSet));
        removeValuesByChar(namesSet, 'a');
        System.out.println("3. " + namesSet);
    }

    public static Set<String> listToSet(List<String>list){
        return new HashSet<>(list);
    }

    public static String getMinAlpha(Set<String> strings){
        return Collections.min(strings);
    }

    public static String getMaxLength(Set<String> strings){
        return Collections.max(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()- o2.length();
            }
        });
    }
    public static void removeValuesByChar(Set<String> strings, char symbol){
        strings.removeIf(string -> string.toLowerCase().contains(String.valueOf(symbol).toLowerCase()));
    }
}
