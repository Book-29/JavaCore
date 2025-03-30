package repositories;

import car.Car;

import java.util.List;

public interface CarRepository {
    void addSaveCar(Car car);
    Car findByBrand(String brand);
    List<Car> findAll();
    void removeCar(Car car);
    void removeAllCars();
    void removeAllCarsFromBrand(String brand);
}
