package ru.kozyrev.homework8.task3;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        PowerfulSet powerfulSet = new PowerfulSet();

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(4);

        // Тестируем методы
        System.out.println("Пересечение: " + powerfulSet.intersection(set1, set2));
        System.out.println("Объединение: " + powerfulSet.union(set1, set2));
        System.out.println("Разность: " + powerfulSet.relativeComplement(set1, set2));
    }
}
