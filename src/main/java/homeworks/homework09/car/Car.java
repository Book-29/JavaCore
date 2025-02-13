package homeworks.homework09.car;

import java.util.Objects;

public class Car {
    private String mark;
    private String model;
    private int year;
    private int power;
    private int acceleration;
    private int suspension;
    private int durability;
    private boolean racing = false;


    public Car(String mark, int year, boolean racing) {
        this.mark = mark;
        this.year = year;
        this.racing = racing;
    }

    public Car() {
    }

    public Car(String mark, String model, int year, int power, int acceleration, int suspension, int durability, boolean racing) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.power = power;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
        this.racing = racing;
    }


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean isRacing() {
        return racing;
    }
    public String getRacing() {
        return racing ? "участник гонки" : "не участник гонки";
    }

    public void setRacing(boolean racing) {
        this.racing = racing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && power == car.power && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && racing == car.racing && Objects.equals(mark, car.mark) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, year, power, acceleration, suspension, durability, racing);
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                ", racing=" + racing +
                '}';
    }
}
