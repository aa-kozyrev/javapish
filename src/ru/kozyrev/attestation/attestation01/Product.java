package ru.kozyrev.attestation.attestation01;

import java.util.Objects;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (!name.isEmpty()) {
            this.name = name;
        } else {
            throw new RuntimeException("Название продукта не может быть пустой строкой.");
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if(cost > 0) {
            this.cost = cost;
        } else {
            throw new RuntimeException("Стоимость продукта не может быть отрицательным числом.");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}
