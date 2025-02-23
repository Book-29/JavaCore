package homeworks.homework11.repository;

import java.util.List;
import homeworks.homework11.model.Car;

public interface CarsRepository {

    List<Car> findAll(String color, int mileage);
    Car findPrice();

}
