package ru.kozyrev.homework03task2;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {

    private static String getGameResult(int vasya, int petya) {
        String result;
        switch(vasya) {
            case 0 -> result = switch (petya) {
                case 0 -> "Ничья";          // Вася-камень против Пети-камня
                case 1 -> "Выиграл Вася";   // Вася-камень против Пети-ножниц
                default -> "Выиграл Петя";  // Вася-камень против Пети-бумаги
            };
            case 1 -> result = switch (petya) {
                case 0 -> "Выиграл Петя";   // Вася-ножницы против Пети-камня
                case 1 -> "Ничья";          // Вася-ножницы против Пети-ножниц
                default -> "Выиграл Вася";  // Вася-ножницы против Пети-бумаги
            };
            default -> result = switch (petya) {
                case 0 -> "Выиграл Вася";   // Вася-бумага против Пети-камня
                case 1 -> "Выиграл Петя";   // Вася-бумага против Пети-ножниц
                default -> "Ничья";         // Вася-бумага против Пети-бумаги
            };
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("ИГРА \"КАМЕНЬ, НОЖНИЦЫ, БУМАГА\"");
        System.out.println("================================");
        System.out.println("Правила:");
        System.out.println("\tКамень ломает ножницы. Ножницы режут бумагу. Бумага обёртывает камень.\n" +
                           "\tЕсли фигуры совпадают, то объявляется ничья.");
        System.out.println("================================");
        System.out.println("камень-0, ножницы-1, бумага-2");

        while (true) {
            System.out.println("\nНажмите клавишу Enter, чтобы продолжить. Чтобы закончить игру введите exit и нажмите клавишу Enter.");
            Scanner terminal = new Scanner(System.in);
            String value = terminal.nextLine();

            if(value.equals("exit")) {
                return;
            }

            RandomGenerator rand = RandomGenerator.getDefault();
            int vasya = rand.nextInt(3);  // 0..2
            int petya = rand.nextInt(3);  // 0..2
            String result = getGameResult(vasya, petya);

            System.out.println("Выбор Васи: " + vasya);
            System.out.println("Выбор Пети: " + petya);
            System.out.println("Результат: " + result);
        }
    }
}
