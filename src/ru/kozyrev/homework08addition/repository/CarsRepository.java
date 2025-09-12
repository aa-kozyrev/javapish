package ru.kozyrev.homework08addition.repository;

public interface CarsRepository {
    void loadFromFile(String filename, String separator);
    void saveToFile(String filename, String separator);
    void printAllCars();
    void printNumbersCars(String color, long mileage);
    void printCountUniqueCars(long n, long m);
    void printColorCar();
    void printAvgCostCar(String model);
}