package repositories.impl;


import car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import repositories.CarRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor

public class CarRepositoryFileImpl implements CarRepository {
    private static final String INPUT_FILE_NAME = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework017/src/main/resource/cars.txt";
    private static final String OUTPUT_FILE_NAME = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework017/src/main/resource/output_cars.txt";
    private static final List<Car> CARS = new ArrayList<>();
    private final String fileName;

    public CarRepositoryFileImpl() {
        this.fileName = INPUT_FILE_NAME;
    }







    @Override
    public Car findByBrand(String mark) {
        if (CARS.isEmpty()) {
            CARS.addAll(findAll());
        }
        return CARS.stream()
                .filter(car -> car.getMark().equals(mark))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Автомобиль не найден"));
    }

    @Override
    public List<Car> findAll() {
        if (CARS.isEmpty()) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                List<Car> carsFromFile = br.lines()
                        .peek(line -> System.out.println("Read line: " + line))
                        .map(line -> {
                            try{
                                return new Car(line);
                            }catch (IllegalArgumentException e){
                                System.out.println("Ошибка при Создании Автомобиля: " + line);
                               throw e;
                            }
                        })
                        .filter(car -> car != null)
                        .collect(Collectors.toList());
                CARS.addAll(carsFromFile);


            } catch (IOException e) {
                throw new RuntimeException("Ошибка при чтении файла", e);
            }
        }
        return CARS;
    }

    @Override
    public void addSaveCar(Car car) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME, true))){
//            writer.write(car.toString());

                writer.write(car.getMark() + "|" + car.getYear() + "|" + car.isRacing());
                writer.newLine(); // Добавляем новую строку


        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    @Override
    public void removeCar(Car car) {

    }

    @Override
    public void removeAllCars() {

    }

    @Override
    public void removeAllCarsFromBrand(String brand) {

    }
}
