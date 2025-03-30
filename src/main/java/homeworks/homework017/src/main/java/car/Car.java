package car;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


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

    public Car(String data) {
        String[] values = data.split("\\|");
        if (values.length != 3) {
            throw new IllegalArgumentException("Не верный формат строки");
        }
        this.mark = values[0];
        this.year = Integer.parseInt(values[1]);
        this.racing = Boolean.parseBoolean(values[2]);
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
