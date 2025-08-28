package ru.kozyrev.homework07;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discountPercent;
    private LocalDate discountDate;

    public DiscountProduct(String name, double cost, int discountPercent, LocalDate discountDate) {
        super(name, cost);
        setDiscountPercent(discountPercent);
        setDiscountDate(discountDate);
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

    @Override
    public void setCost(double cost) {
        double discount = 0;
        if (!LocalDate.now().isAfter(discountDate)) {
            discount = (cost*discountPercent)/100;
        }
        super.setCost(cost - discount);
    }
}
