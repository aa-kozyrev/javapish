package ru.kozyrev.homework07;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private double balance;
    private final ArrayList<Product> products;

    public Person(String name, double balance) {
        setName(name);
        setBalance(balance);
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if(name.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустым.");
        } else {
            if(name.length() < 3) {
                throw new RuntimeException("Имя не может быть короче 3 символов.");
            } else {
                this.name = name;
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            throw new RuntimeException("Деньги не могут быть отрицательными.");
        }
    }

    public boolean buy(Product product) {
        if(product.getCost() <= this.getBalance()) {
            this.setBalance(this.getBalance() - product.getCost());
            this.products.add(product);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(balance, person.balance) == 0 && Objects.equals(name, person.name) && Objects.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, products);
    }
}
