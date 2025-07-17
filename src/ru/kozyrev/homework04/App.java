package ru.kozyrev.homework04;

public class App {
    public static void main(String[] args) {
        Tv livingRoomTv = new Tv("Sony", "KD-75X81K", 75, "3840x2160", "QLED", true, 4);
        Tv bedroomTv = new Tv("Samsung", "UE43DU7100UXRU", 43, "3840x2160", "OLED", true, 3);
        Tv kitchenTv = new Tv("Haier", "32 Smart TV M1", 32, "1366x768", "VA", true, 3);

        livingRoomTv.powerOn();
        if(livingRoomTv.getVolume() < 20) {
            livingRoomTv.powerOff();
        }

        bedroomTv.powerOn();
        bedroomTv.setCurrentChannel(15);
        bedroomTv.setVolume(100);

        kitchenTv.powerOn();
        System.out.println();
        System.out.println("Телевизор в гостиной: " + livingRoomTv);
        System.out.println("Телевизор в спальне: " + bedroomTv);
        System.out.println("Телевизор на кухне: " + kitchenTv);


        // 6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры или случайным числом.
        
    }
}
