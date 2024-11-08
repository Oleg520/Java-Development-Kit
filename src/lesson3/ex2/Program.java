package lesson3.ex2;

import java.util.Arrays;

/**
 * Описать собственную коллекцию – список на основе массива.
 * Коллекция должна иметь возможность хранить любые типы данных,
 * иметь методы добавления и удаления элементов.
 */
public class Program<T> {
    private Object[] array;
    private int size;

    public Program(int size) {
        this.array = new Object[size];
    }

    public void add(T t) {
        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = t;
    }

    public void remove(T t) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(t)) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
                break;
            }
        }
    }
}
