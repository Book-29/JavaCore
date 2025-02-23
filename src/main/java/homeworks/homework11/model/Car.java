package homeworks.homework11.model;
//Реализовать класс Автомобиль. У класса есть поля, свойства и
//методы.
//Поля класса:
//а) Номер автомобиля;
//б) Модель;
//в) Цвет;
//г) Пробег;
//д) Стоимость.
//Обратить внимание на переопределение метода toString, на сеттеры и
//геттеры, модификаторы доступа полей


import java.util.Objects;

public class Car {
    private String number;
    private String model;
    private String color;
    private int mileage;
    private int price;

    public Car(String number, String model, String color, int mileage, int price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && mileage == car.mileage && price == car.price && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
