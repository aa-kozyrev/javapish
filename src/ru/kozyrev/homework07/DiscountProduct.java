package ru.kozyrev.homework07;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private int discountPercent;
    private LocalDate discountDate;

    public DiscountProduct(String name, double cost, int discountPercent, LocalDate discountDate) {
        super(name, cost);
        setDiscountDate(discountDate);
        setDiscountPercent(discountPercent);
    }

    public void setDiscountPercent(int discountPercent) {
        if(discountPercent > 0) {
            if(discountPercent < 99) {
                this.discountPercent = discountPercent;
            } else {
                throw new RuntimeException("Скидка на продукт не может быть больше 99%");
            }
        } else {
            throw new RuntimeException("Скидка на продукт не может быть меньше 0%");
        }
    }

    public void setDiscountDate(LocalDate discountDate) {
        if (discountDate != null) {
            this.discountDate = discountDate;
        } else {
            throw new RuntimeException("Дата, до которой действует скидка не может быть пустой.");
        }
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    @Override
    public double getCost() {
        double discount = 0;
        double cost = super.getCost();
        if (discountDate.isAfter(LocalDate.now())) {
            discount = (cost*discountPercent)/100;
        }
        return cost - discount;
    }

    public double getCostWithoutDiscont() {
        return super.getCost();
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + super.getName() + '\'' +
                ", cost=" + super.getCost() +
                ", discountPercent=" + discountPercent +
                ", discountDate=" + discountDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountProduct product = (DiscountProduct) o;
        return Double.compare(getCost(), product.getCost()) == 0 && Objects.equals(getName(), product.getName()) &&
                discountPercent == product.discountPercent && Objects.equals(discountDate, product.discountDate);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), super.getCost(), discountPercent, discountDate);
    }
}
