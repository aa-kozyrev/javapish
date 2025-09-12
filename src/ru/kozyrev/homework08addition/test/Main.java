package ru.kozyrev.homework08addition.test;

import ru.kozyrev.homework08addition.repository.CarsRepository;
import ru.kozyrev.homework08addition.repository.CarsRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        final String workDir =  System.getProperty("user.dir");
        final String inputFile = workDir + "/src/ru/kozyrev/homework08addition/data/cars.txt";
        final String outputFile = workDir + "/src/ru/kozyrev/homework08addition/data/output.txt";

        CarsRepository repository = new CarsRepositoryImpl();

        // загрузка автомобилей из файла cars.txt
        String separator = "\\|";
        repository.loadFromFile(inputFile, separator);

        // Автомобили в базе
        repository.printAllCars();
        System.out.println();

        // 1) Номера всех автомобилей, имеющих заданный в переменной цвет colorToFind или нулевой пробег mileageToFind.
        String colorToFind = "Black";
        long mileageToFind = 0L;
        repository.printNumbersCars(colorToFind, mileageToFind);

        // 2) Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        long n = 700_000L;
        long m = 800_000L;
        repository.printCountUniqueCars(n, m);

        // 3) Вывести цвет автомобиля с минимальной стоимостью.
        repository.printColorCar();

        // 4) Среднюю стоимость искомой модели modelToFind
        String modelToFind = "Toyota";
        repository.printAvgCostCar(modelToFind);
        modelToFind = "Volvo";
        repository.printAvgCostCar(modelToFind);
        System.out.println();

        // сохранение автомобилей в файл output.txt
        separator = ",";
        repository.saveToFile(outputFile, separator);
    }
}
