package ru.kozyrev.homework04;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // СОЗДАДИМ ТРИ ОБЪЕКТА "ТЕЛЕВИЗОР"
        Tv livingRoomTv = new Tv("Sony", "KD-75X81K", 75, "3840x2160", "QLED", true, 4);
        Tv bedroomTv = new Tv("Samsung", "UE43DU7100UXRU", 43, "3840x2160", "OLED", true, 3);
        Tv kitchenTv = new Tv("Haier", "32 Smart TV M1", 32, "1366x768", "VA", true, 3);

        // ПОУПРАВЛЯЕМ СОЗДАННЫМИ ОБЪЕКТАМИ:
        // телевизор-в-комнате
        livingRoomTv.powerOn();                 // включим
        if(livingRoomTv.getVolume() < 20) {     // включим, если уровень громкости менее 20
            livingRoomTv.powerOff();
        }

        // телевизор-в-спальной
        bedroomTv.powerOn();                // включим
        bedroomTv.setCurrentChannel(15);    // переключим на канал № 15
        bedroomTv.setVolume(100);           // изменим уровень громкости

        // телевизор-на-кухне
        kitchenTv.powerOn();    // включим

        // выведем информацию о телевизорах
        System.out.println();
        System.out.println("Телевизор в гостиной: " + livingRoomTv.showTvInfo());
        System.out.println("Телевизор в спальне: " + bedroomTv.showTvInfo());
        System.out.println("Телевизор на кухне: " + kitchenTv.showTvInfo());

        // 6. ДОПОЛНИТЕЛЬНО. ЗАДАВАТЬ ПАРАМЕТРЫ КЛАССА ТЕЛЕВИЗОР С КЛАВИАТУРЫ ИЛИ СЛУЧАЙНЫМ ЧИСЛОМ.
        Scanner sc = new Scanner(System.in);

        // изменим канал у телевизор-на-кухне
        System.out.println();
        System.out.print("Введите номер канала на который надо переключить телевизор " + kitchenTv.getBrand() + ": ");
        int value = sc.nextInt();
        kitchenTv.setCurrentChannel(value);

        // изменим уровень громкости у телевизор-в-спальной
        System.out.println();
        System.out.print("Введите уровень громкости на который надо настроить телевизор " + bedroomTv.getBrand() + ": ");
        value = sc.nextInt();
        bedroomTv.setVolume(value);

        // выведем информацию о телевизорах
        System.out.println();
        System.out.println("Телевизор в гостиной: " + livingRoomTv.showTvInfo());
        System.out.println("Телевизор в спальне: " + bedroomTv.showTvInfo());
        System.out.println("Телевизор на кухне: " + kitchenTv.showTvInfo());
    }
}
