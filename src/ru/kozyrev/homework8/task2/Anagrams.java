package ru.kozyrev.homework8.task2;

import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String s = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
        System.out.print("Введите вторую строку: ");
        String t = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    private static boolean isAnagram(String s, String t) {
        // если строки разной длины, то анаграмма не получится
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> charsHashMap = new HashMap<>();
        // помещаем в HashMap символы первой строки (в ключ), при этом в значении подсчитываем частоту вхождения символов в строку
        for (char ch1 : s.toCharArray()) {
            charsHashMap.put(ch1, charsHashMap.getOrDefault(ch1, 0) + 1);
        }

        // помещаем в HashMap символы второй строки, но при этом ...
        for (char ch2 : t.toCharArray()) {
            // если ключа в HashMap нет, то анаграмма не получится (в первой строке нет буквы, которая есть во второй строке)
            if (!charsHashMap.containsKey(ch2)) {
                return false;
            }
            // если ключ (буква) уже есть в HashMap, то значение уменьшаем на 1
            charsHashMap.put(ch2, charsHashMap.get(ch2) - 1);
            // если значение стало равно 0 (после уменьшения на 1), то все совпадения уже прошли - удаляем букву из HashMap
            if (charsHashMap.get(ch2) == 0) {
                charsHashMap.remove(ch2);
            }
        }

        // если в итоге HashMap оказался пуст, то это значит что все буквы в строках совпали
        return charsHashMap.isEmpty();
    }
}
