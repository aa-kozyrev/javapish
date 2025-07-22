package ru.kozyrev.homework04task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";  // "замкнутая" клавиатура QWERTY
        Scanner terminal = new Scanner(System.in);
        char character, leftCharacter;
        int position;
        String str;
        while (true) {
            System.out.print("Введите букву английского алфавита: ");
            character = terminal.nextLine().toLowerCase().charAt(0);    // из введенной строки достанем первый символ, в нижнем регистре

            if (!keyboard.contains(String.valueOf(character))) {
                System.out.println("Вы ввели не символ английского алфавита.");
            } else {
                position = keyboard.indexOf(character);
                if(position == 0) {
                    leftCharacter = keyboard.charAt(keyboard.length() - 1);
                } else {
                    leftCharacter = keyboard.charAt(position - 1);
                }
                System.out.println("Слева от английской буквы " + character + " находится буква " + leftCharacter);
            }
            System.out.print("Нажмите клавишу Enter чтобы продолжить. Для выхода из программы введите exit: ");
            str = terminal.nextLine();
            if(str.equals("exit")) {
                return;
            }
            System.out.println();
        }
    }
}
