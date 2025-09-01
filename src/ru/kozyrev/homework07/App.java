package ru.kozyrev.homework07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        for (String word : words1) {
            String[] words2 = word.split("=");  // извлекли из покупателя ФИО и сумму
            try {
                Person person = new Person(words2[0].trim(), Double.parseDouble(words2[1].trim()));
                persons.add(person);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        // вводим Продукты
        ArrayList<Product> products = new ArrayList<>();
        System.out.print("Введите данные продуктов: ");
        terminal = new Scanner(System.in);
        inputString = terminal.nextLine();
        words1 = inputString.split(";");  // разбили строку на массив продуктов с их данными
        for (String word : words1) {
            String[] words2 = word.split("=");  // извлекли из продукта название и стоимость
            try {
                Product product = new Product(words2[0].trim(), Double.parseDouble(words2[1].trim()));
                products.add(product);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        // вводим Скидочные Продукты
        ArrayList<DiscountProduct> discountProducts = new ArrayList<>();
        System.out.print("Введите данные скидочных продуктов: ");
        terminal = new Scanner(System.in);
        inputString = terminal.nextLine();
        words1 = inputString.split(";");  // разбили строку на массив продуктов с их данными
        for (String word : words1) {
            String[] words2 = word.split("=");  // извлекли из продукта название и остальное (стоимость + скидка + дата окончания скидки)
            String[] words3 = words2[1].split(",");  // извлекли остальное - стоимость, скидку, дату окончания скидки
            try {
                DiscountProduct discountProduct = new DiscountProduct(words2[0].trim(), Double.parseDouble(words3[0].trim()),
                                                                      Integer.parseInt(words3[1].trim()),
                                                                      LocalDate.parse(words3[2].trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                discountProducts.add(discountProduct);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println("Скидочные продукты:");
        for (DiscountProduct discountProduct : discountProducts) {
            System.out.println("Name=" + discountProduct.getName() + " Cost=" + discountProduct.getCost() +
                    " CostWithoutDiscont=" + discountProduct.getCostWithoutDiscont());
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
                    for (DiscountProduct product : discountProducts) {
                        if (product.getName().equals(words1[1].trim())) {
                            // нашли скидочный продукт
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
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.print("Ничего не куплено");
            } else {
                for (int i = 0; i < person.getProducts().size(); i++) {
                    if (i == 0) {
                        System.out.print(person.getProducts().get(i).getName());
                    } else {
                        System.out.print(", " + person.getProducts().get(i).getName());
                    }
                }
            }
            System.out.println();
        }
    }
}
