package ru.kozyrev.homework08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Car auto1 = new Car("a123me", "Mercedes", "White", 8300000);
        Car auto2 = new Car("b873of", "Volga", "Black", 673000);
        Car auto3 = new Car("w487mn", "Lexus", "Grey", 76000, 900000);
        Car auto4 = new Car("p987hj", "Volga", "Red", 610, 704340);
        Car auto5 = new Car("c987ss", "Toyota", "White", 254000, 761000);
        Car auto6 = new Car("o983op", "Toyota", "Black", 698000, 740000);
        Car auto7 = new Car("p146op", "BMW", "White", 271000, 850000);
        Car auto8 = new Car("u893ii", "Toyota", "Purple", 210900, 440000);
        Car auto9 = new Car("l097df", "Toyota", "Black", 108000, 780000);
        Car auto10 = new Car("y876wd", "Toyota", "Black", 160000, 1000000);

        ArrayList<Car> cars = new ArrayList<>();
        Collections.addAll(cars, auto1, auto2, auto3, auto4, auto5, auto6, auto7, auto8, auto9, auto10);

        // 1) Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind.
        System.out.println("::::::: Задание 1 :::::::");
        String colorToFind = "Black";
        double mileageToFind = 0;
        String result = cars.stream()
                .filter(car -> car.getColor()
                .equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + result);
        System.out.println();

        // 2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        System.out.println("::::::: Задание 2 :::::::");
        System.out.println();

        // 3) Вывести цвет автомобиля с минимальной стоимостью.
        System.out.println("::::::: Задание 3 :::::::");
        cars.stream()
                .reduce((car1, car2) -> car1.getCost() < car2.getCost() ? car1 : car2)
                .ifPresent(car -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + car.getColor()));
        System.out.println();

        // 4) Среднюю стоимость искомой модели modelToFind
        System.out.println("::::::: Задание 4 :::::::");
        final String modelToFind = "Volvo";
        double avgCost = cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind))
                .mapToDouble(Car::getCost)
                .average()
                .orElse(0);
        System.out.printf("Средняя стоимость модели %s: %.2f", modelToFind, avgCost);
        System.out.println();
    }
}
