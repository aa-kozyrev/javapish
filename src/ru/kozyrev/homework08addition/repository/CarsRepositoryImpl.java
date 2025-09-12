package ru.kozyrev.homework08addition.repository;

import ru.kozyrev.homework08addition.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public void loadFromFile(String filename, String separator) {
        cars.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();  // пропустим шапку с названиями столбцов
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    cars.add(Car.stringToCar(line, separator));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }

    @Override
    public void saveToFile(String filename, String separator) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("[НОМЕР_АВТОМОБИЛЯ][МОДЕЛЬ][ЦВЕТ][ПРОБЕГ][ЦЕНА]");  // шапка с названиями столбцов
            for (Car car : cars) {
                writer.println(car.carToString(separator));
            }
            System.out.println("База автомобилей сохранена в файл \"" + filename + "\"");
        } catch (IOException e) {
            System.out.println("При сохранении базы автомобилей в файл \"" + filename + "\" произошла ошибка: " + e.getMessage());
        }
    }

    @Override
    public void printAllCars() {
        int[] columnWidths = {10, 12, 10, 12, 15};
        String[] row = {"Number", "Model", "Color", "Mileage", "Cost"};
        // заголовок
        System.out.println("Автомобили в базе:");
        // "шапка" таблицы
        for (int i = 0; i < row.length; i++) {
            System.out.printf("%-" + columnWidths[i] + "s", row[i]);
        }
        System.out.println();
        // строки таблицы
        for (Car car : cars) {
            row[0] = car.getNumber();
            row[1] = car.getModel();
            row[2] = car.getColor();
            row[3] = String.valueOf(car.getMileage());
            row[4] = String.valueOf(car.getCost());

            for (int i = 0; i < row.length; i++) {
                System.out.printf("%-" + columnWidths[i] + "s", row[i]);
            }
            System.out.println();
        }
    }
    @Override
    public void printNumbersCars(String color, long mileage) {
        String result = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color) || car.getMileage() == mileage)
                .map(Car::getNumber).
                collect(Collectors.joining(" "));
        System.out.println("Номера автомобилей по цвету или пробегу: " + result);
    }

    @Override
    public void printCountUniqueCars(long fromCost, long toCost) {
        long cnt = cars.stream()
                .filter(car -> car.getCost() >= fromCost && car.getCost() <= toCost)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("Уникальные модели автомобилей: " + cnt + " шт.");
    }

    @Override
    public void printColorCar() {
        cars.stream()
                .reduce((car1, car2) -> car1.getCost() < car2.getCost() ? car1 : car2)
                .ifPresent(car -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + car.getColor()));
    }

    @Override
    public void printAvgCostCar(String model) {
        double avgCost = cars.stream().
                filter(car -> car.getModel().equalsIgnoreCase(model))
                .mapToDouble(Car::getCost)
                .average()
                .orElse(0);
        System.out.printf("Средняя стоимость модели %s: %.2f\n", model, avgCost);
    }
}
