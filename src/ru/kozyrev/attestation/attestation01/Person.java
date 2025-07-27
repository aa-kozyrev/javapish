package ru.kozyrev.attestation.attestation01;

import java.util.Arrays;
import java.util.Objects;

//Если Покупатель может позволить себе Продукт, то Продукт добавляется в пакет. Если у Покупателя недостаточно денег, то добавление не происходит.

public class Person {
    private String name;
    private double balance;
    private Product[] products;

    public Person(String name, double balance) {
        setName(name);
        setBalance(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if(name.isEmpty()) {
            throw new RuntimeException("Имя не может быть пустой строкой.");
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
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new RuntimeException("Деньги не могут быть отрицательным числом.");
        }
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
