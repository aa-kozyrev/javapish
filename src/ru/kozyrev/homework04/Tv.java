package ru.kozyrev.homework04;

public class Tv {
    private final String brand;             // производитель
    private final String model;             // модель
    private final int screenSize;           // диагональ
    private final String resolution;        // разрешение экрана
    private final String displayType;       // тип экрана
    private final boolean isSmartTv;        // поддержка Smart TV
    private final int hdmiPortsCount;       // количество HDMI-портов
    private int currentChannel;             // номер текущего канала
    private int volume;                     // текущий уровень громкости
    private boolean isOn;                   // состояние (включен/выключен)

    public Tv(String brand, String model, int screenSize, String resolution, String displayType, boolean isSmartTv, int hdmiPortsCount) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.displayType = displayType;
        this.isSmartTv = isSmartTv;
        this.hdmiPortsCount = hdmiPortsCount;
        this.currentChannel = 1;
        this.volume = 10;
        this.isOn = false;
    }

    public String getBrand() {
        return brand;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
        System.out.println("Переключено на канал " + currentChannel + " (" +  brand  + " " + model + ")");
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Громкость изменена на " + volume + " (" +  brand  + " " + model + ")");
    }

    public void powerOn() {
        isOn = true;
        System.out.println("Телевизор включен (" +  brand  + " " + model + ")");
    }

    public void powerOff() {
        isOn = false;
        System.out.println("Телевизор выключен (" +  brand  + " " + model + ")");
    }

    public String showTvInfo() {
        return  "brand='" + brand + "' " +
                ", model='" + model + "' " +
                ", screenSize=" + screenSize +
                ", resolution='" + resolution + "' " +
                ", displayType='" + displayType + "' " +
                ", isSmartTv=" + isSmartTv +
                ", hdmiPortsCount=" + hdmiPortsCount +
                ", currentChannel=" + currentChannel +
                ", volume=" + volume +
                ", isOn=" + isOn;
    }
}
