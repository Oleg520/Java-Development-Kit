package lesson3.classwork.ex1;

import java.io.DataInput;
import java.io.InputStream;

/**
 * Создать обобщенный класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K),
 * конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трех переменных.
 * <p>
 * Создать метод, выводящий на консоль имена классов для трех переменных класса.
 * Наложить ограничения на параметры типа:
 * T должен реализовать интерфейс Comparable,
 * V должен реализовать интерфейс DataInput и расширять класс InputStream,
 * K должен расширять класс Number.
 */
public class MyClass<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private V v;
    private K k;

    MyClass(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    T getT() {
        return this.t;
    }

    V getV() {
        return this.v;
    }

    K getK() {
        return this.k;
    }

    public void printClass() {
        System.out.println(t.getClass().getName());
        System.out.println(v.getClass().getName());
        System.out.println(k.getClass().getName());
    }

}
