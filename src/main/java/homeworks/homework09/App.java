package homeworks.homework09;

import homeworks.homework09.car.PerformanceCar;
import homeworks.homework09.car.ShowCar;
import homeworks.homework09.car.Car;

public class App {
    public static void main(String[] args) {
        Car car = new Car("Audi", 2020, true);
        System.out.println(car);


        PerformanceCar performanceCar = new PerformanceCar("Audi", 2022, true);
        System.out.println(performanceCar);

        ShowCar showCar = new ShowCar("BMV", 2022, false, 5);
        System.out.println(showCar);


        Garage garage = new Garage();
        garage.addCar(car);
        garage.addCar(performanceCar);
        garage.addCar(showCar);

        System.out.println(garage);
    }
}
