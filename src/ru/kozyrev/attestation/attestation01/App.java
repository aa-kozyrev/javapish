package ru.kozyrev.attestation.attestation01;

import java.util.ArrayList;
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

        // Покупки
        System.out.println();
        while (true) {
            System.out.print("Введите данные для покупки или END для выхода из программы: ");
            terminal = new Scanner(System.in);
            inputString = terminal.nextLine();
            if (inputString.equals("END")) {
                break;
            }
            words1 = inputString.split("-");  // разбили строку на части
            for (Person person : persons) {
                if (person.getName().equals(words1[0].trim())) {
                    // нашли покупателя
                    for (Product product : products) {
                        if (product.getName().equals(words1[1].trim())) {
                            // нашли продукт
                            if (person.buy(product)) {
                                System.out.println(person.getName() + " купил(а) " + product.getName());
                            } else {
                                System.out.println(person.getName() + " не может позволить себе " + product.getName());
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }

        // Вывод покупателей с их покупками
        System.out.println();
        for (Person person : persons) {
            //System.out.println(persons.get(i).toString());
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.print("Ничего не куплено");
            } else {
                for (int j = 0; j < person.getProducts().size(); j++) {
                    if (j == 0) {
                        System.out.print(person.getProducts().get(j).getName());
                    } else {
                        System.out.print(", " + person.getProducts().get(j).getName());
                    }
                }
            }
            System.out.println();
        }
    }
}
