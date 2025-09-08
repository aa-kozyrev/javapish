package ru.kozyrev.homework8.task3;

import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {

    // Возвращает пересечение двух наборов
    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>(set1);
        set.retainAll(set2);  // сохраняем элементы, которые существуют и в set1 и в set2
        return set;
    }

    // Возвращает объединение двух наборов
    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>(set1);
        set.addAll(set2);  // сохраняем все элементы из set1 и set2
        return set;
    }

    // Возвращает элементы первого набора без тех, которые находятся также и во втором наборе
    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> set = new HashSet<>(set1);
        set.removeAll(set2);  // удаляем одинаковые элементы
        return set;
    }
}
