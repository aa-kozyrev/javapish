package ru.kozyrev.homework08;

public class Main {
    public static void main(String[] args) {
        Car auto1 = new Car("ax859kto", "Lada", "Red", 15000, 800000);
        Car auto2 = new Car("zx365tmn", "KIA", "Green", 150000.8, 1500000.15);
        Car auto3 = new Car("zx365tmn", "KIA", "Green", 150000.8, 1500000.15);

        System.out.println(auto1);
        System.out.println(auto1.hashCode());

        System.out.println(auto2);
        System.out.println(auto2.hashCode());

        System.out.println(auto1.equals(auto2));

        System.out.println();
        System.out.println(auto3);
        System.out.println(auto3.hashCode());

        System.out.println(auto2.equals(auto3));
    }
}
