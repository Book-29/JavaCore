

import car.Car;
import repositories.CarRepository;
import repositories.impl.CarRepositoryFileImpl;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CarRepositoryFileImpl carRepository = new CarRepositoryFileImpl();

       List<Car> cars = carRepository.findAll();
       System.out.println(cars);
       try {
           Car foundCar = carRepository.findByBrand("Volga");
           System.out.println(foundCar);

       }
       catch(Exception e) {
           System.out.println("Автомобиль не найден");


       }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework17/src/main/resource/cars.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("[|]");
                Car car = new Car(values[0], Integer.parseInt(values[1]), Boolean.parseBoolean(values[2]));
                carRepository.addSaveCar(car);

                System.out.println("Автомобиль добавлен и сохранен в файле." + car);
            }
        }catch(IOException e) {
            System.out.println("Ошибка при чтении файла.");
        }


    }
}
