package lesson4.cw.ex3;

import java.util.*;

/*
    В рамках выполнения задачи необходимо:
    0. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
    1. Найдите человека с самым маленьким номером телефона
    2. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
 */
public class Ex3 {
    public static void main(String[] args) {
        Map<Integer, String> phonebook = new HashMap<>(Map.of(
                850141, "Alex",
                586228, "Larisa",
                654328, "Valera",
                792415, "Arkadiy",
                555530, "Vladimir",
                103482, "Margarita")
        );


        System.out.println("1. " + getMinNumber(phonebook));
        System.out.println("2. " + getNumberFromMaxAlphaName(phonebook));
    }

    public static String getMinNumber(Map<Integer, String> map) {
        Set<Integer> numbers = new HashSet<>(map.keySet());
        int min = Collections.min(numbers);

        return String.format("%s, %s", min, map.get(min));
    }

    public static String getNumberFromMaxAlphaName(Map<Integer, String> map) {
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        Map.Entry<Integer,String> maxName = Collections.max(set, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));
        return String.format("%s, %s", maxName.getValue(), maxName.getKey());
    }
}





