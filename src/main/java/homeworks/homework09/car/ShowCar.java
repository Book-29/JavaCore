package homeworks.homework09.car;

import java.util.Objects;

public class ShowCar extends Car{

   private int stars;


    public ShowCar(String mark, int year, boolean racing, int stars) {
        super(mark, year, racing);
        this.stars = stars;
    }

    public ShowCar(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "mark='" + super.getMark() +
                ", year=" + super.getYear() +
                ", racing=" + super.isRacing() +
                ", stars=" + stars +
                '}';
    }
}
