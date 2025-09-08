package ru.kozyrev.homework8.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Uniques {

    public static <T> Set<T> getUniques(ArrayList<T> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        // целые числа
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(15);
        numbers.add(2);
        numbers.add(2);
        numbers.add(8);
        numbers.add(8);
        Set<Integer> uniqueNumbers = getUniques(numbers);
        System.out.println("Уникальные числа: " + uniqueNumbers);

        // строки
        ArrayList<String> words = new ArrayList<>();
        words.add("пенал");
        words.add("дневник");
        words.add("тетрадь");
        words.add("тетрадь");
        words.add("ручка");
        words.add("ручка");
        words.add("учебник");
        words.add("учебник");
        Set<String> uniqueWords = getUniques(words);
        System.out.println("Уникальные строки: " + uniqueWords);
    }
}
