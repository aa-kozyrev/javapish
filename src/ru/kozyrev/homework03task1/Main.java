package ru.kozyrev.homework03task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите своё имя пожалуйста: ");
        Scanner terminal = new Scanner(System.in);
        String userName = terminal.nextLine();
        System.out.println("Привет, " + userName);
    }
}
