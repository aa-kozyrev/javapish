package ru.kozyrev.homework04task2;

public class Main {
    public static void main(String[] args) {
        String arrowsString = ">>--><--<<>->-->-<--<<>>-->--<-<-<>>-->-<--<<<>>-->--<<<>>--><----<<>>--><--<<>>--><--<<>>----><--<>----<<";  // входная строка со "стрелами"
        int arrowsCount = 0;
        System.out.println("Исходная строка: " + arrowsString);
        // ищем вхождения подстрок-"стрел"
        for (int i = 0; i <= arrowsString.length() - 5; i++) {
            String substr = arrowsString.substring(i, i + 5);
            if(substr.equals(">>-->") || substr.equals("<--<<")) {
                arrowsCount = arrowsCount + 1;
            }
        }
        System.out.println("В исходной строке есть " + arrowsCount + " стрел вида '>>-->' и '<--<<'");
    }
}
