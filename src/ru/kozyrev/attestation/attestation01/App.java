package ru.kozyrev.attestation.attestation01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // вводим Покупателей
        ArrayList<Person> persons = new ArrayList<>();
        System.out.print("Введите данные покупателей: ");
        Scanner terminal = new Scanner(System.in);
        String inputString = terminal.nextLine();
        String[] words1 = inputString.split(";");  // разбили строку на массив покупателей с их данными
        for (String word1 : words1) {
            String[] words2 = word1.split("=");  // извлекли из покупателя ФИО и сумму
            Person person = new Person(words2[0].trim(), Double.parseDouble(words2[1].trim()));
            persons.add(person);
        }
/*        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).toString());
        }
        System.out.println();*/

        // вводим Продукты
        ArrayList<Product> products = new ArrayList<>();
        System.out.print("Введите данные продуктов: ");
        terminal = new Scanner(System.in);
        inputString = terminal.nextLine();
        words1 = inputString.split(";");  // разбили строку на массив продуктов с их данными
        for (String word1 : words1) {
            String[] words2 = word1.split("=");  // извлекли из продукта название и стоимость
            Product product = new Product(words2[0].trim(), Double.parseDouble(words2[1].trim()));
            products.add(product);
        }
/*        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
        System.out.println();*/

        // Покупки
        while (true) {
            System.out.print("Введите данные для покупки или END для выхода из программы: ");
            terminal = new Scanner(System.in);
            inputString = terminal.nextLine();
            if (inputString.equals("END")) {
                break;
            }
            words1 = inputString.split("-");  // разбили строку на части
            for (int i = 0; i < persons.size(); i++) {
                if(persons.get(i).getName().equals(words1[0].trim())) {
                    // нашли покупателя
                    for (int j = 0; j < products.size(); j++) {
                        if(products.get(j).getName().equals(words1[1].trim())) {
                            // нашли продукт
                            if(persons.get(i).buy(products.get(j))) {
                                System.out.println(persons.get(i).getName() + " купил(а) " + products.get(j).getName());
                            } else {
                                System.out.println(persons.get(i).getName() + " не может позволить себе " + products.get(j).getName());
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }

        // Вывод покупателей с их покупками
/*
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i).toString());
        }
        System.out.println();
*/
    }
}
