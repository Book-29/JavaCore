package homeworks.homework09;
//    Garage – место, где остаются все автомобили, когда они не участвуют в
//    гонках. Гараж также предоставляет возможность модифицировать
//    припаркованный автомобиль. Включает parkedCars (массив объектов типа Car).
//
import homeworks.homework09.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Garage {

    private List<Car> parkedCars;
    public Garage() {
        this.parkedCars = new ArrayList<>();
    }

    public void addCar(Car car) {
      if (!car.isRacing()){
          this.parkedCars.add(car);
      }
    }
    public void removeCar(Car car) {
        parkedCars.remove(car);
    }
    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parkedCars);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}
