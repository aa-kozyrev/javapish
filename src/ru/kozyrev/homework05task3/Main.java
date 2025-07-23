package ru.kozyrev.homework05task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String inputString = "FdAeCbg zyxStWvU";  // входная строка - два "слова на английском", разделенные одним пробелом
        StringBuilder outputString = new StringBuilder();

        System.out.println("Исходная строка: " + inputString);

        String[] words = inputString.toLowerCase().split(" ");  // разбили на слова (в массив)
        for (int i = 0; i < words.length; i++) {
            String word = words[i];                         // достаем "слово" из массива
            char[] charsArray = word.toCharArray();         // "слово" в "массив букв"
            Arrays.sort(charsArray);                        // сортируем "массив букв"
            outputString.append(charsArray).append(" ");    // добавляем отсортированный "массив букв" в выходную строку
        }
        System.out.println("\"Отсортированная\" строка: " + outputString);
    }
}
