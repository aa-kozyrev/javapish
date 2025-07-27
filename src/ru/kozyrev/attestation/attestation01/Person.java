package ru.kozyrev.attestation.attestation01;

import java.util.Arrays;
import java.util.Objects;

// Имя не может быть пустой строкой и не может быть короче 3 символов. Деньги не могут быть отрицательным числом.
//Если Покупатель может позволить себе Продукт, то Продукт добавляется в пакет. Если у Покупателя недостаточно денег, то добавление не происходит.

public class Person {
    private String name;
    private double balance;
    private Product[] products;

    public Person(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Product[] getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(balance, person.balance) == 0 && Objects.equals(name, person.name) && Objects.deepEquals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, Arrays.hashCode(products));
    }
}
