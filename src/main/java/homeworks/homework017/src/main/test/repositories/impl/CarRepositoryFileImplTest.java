package repositories.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import car.Car;
import repositories.CarRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {
    private CarRepositoryFileImpl carRepository;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryFileImpl();
    }


    @Test
    void testFindAll() {
        Car car1 = new Car("Toyota", 2020, true);
        Car car2 = new Car("Honda", 2019, true);
        carRepository.addSaveCar(car1);
        carRepository.addSaveCar(car2);

        List<Car> cars = carRepository.findAll();

        assertTrue(cars.contains(car1));
//        assertTrue(cars.contains(car2));
    }



}



