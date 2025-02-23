package homeworks.homework11.repository;

import homeworks.homework11.model.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;



public class CarsRepositoryImpl implements CarsRepository{
   private List<Car> cars;
    public CarsRepositoryImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public List<Car> findAll(String color, int mileage) {
        return cars.stream()
                .filter(car -> car.getColor().equals(color) || car.getMileage() == mileage)
                .collect(Collectors.toList());
    }

    @Override
    public Car findPrice() {
        return cars.stream()
                .min(Comparator.comparing(Car::getPrice))
                .orElse(null);
    }
}
