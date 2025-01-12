package homeworks.homework05;
//1. В класс Телевизор добавить поля (если не были добавлены ранее):
//1) Номер включенного канала — integer;
//2) Громкость звука — integer (от 0 до 100);
//3) Признак включенного телевизора — boolean.
//2. Переопределить метод toString класса Телевизор таким образом, чтобы
//распечатывались: название класса, все поля класса и их значения.
//3. Добавить в класс Телевизор методы equals и hashcode.

import java.util.Objects;

public class Television {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private Integer length;
    private Integer sound;
    private Integer volume;
    private Integer channel;
    private Boolean modeOn;

    public Television(String brand, String model, int year, String color, int price, Integer length) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.length = length;


    }

    public Television() {
    }
    public Television( String model, Integer volume, Integer channel, Boolean modeOn) {
        this.model = model;
        this.volume = volume;
        this.channel = channel;
        this.modeOn = modeOn;
    }

    public void setBrand(String brand) {
        this.brand = brand;

    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        
        this.volume = Math.min(Math.max(volume, 0), 100);
    }
    public void setSound(Integer sound) {
        this.sound = sound;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public void setModeOn(boolean modeOn) {
        this.modeOn = modeOn;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getSound() {
        return sound;
    }

    public Integer getChannel() {
        return channel;
    }

    public Boolean getModeOn() {
        return modeOn;
    }

    @Override
    public String toString() {
        return "Television{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", length=" + length +
                ", sound=" + sound +
                ", volume=" + volume +
                ", channel=" + channel +
                ", modeOn=" + modeOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return year == that.year && price == that.price && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(color, that.color) && Objects.equals(length, that.length) && Objects.equals(sound, that.sound) && Objects.equals(volume, that.volume) && Objects.equals(channel, that.channel) && Objects.equals(modeOn, that.modeOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, color, price, length, sound, volume, channel, modeOn);
    }


}