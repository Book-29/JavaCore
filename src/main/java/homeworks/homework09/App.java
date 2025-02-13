package homeworks.homework09;

import homeworks.homework09.car.PerformanceCar;
import homeworks.homework09.car.ShowCar;
import homeworks.homework09.car.Car;

import java.io.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        Car car = new Car("Audi", 2020, true);
//        System.out.println(car);
//
//
//        PerformanceCar performanceCar = new PerformanceCar("Audi", 2022, true);
//        System.out.println(performanceCar);
//
//        ShowCar showCar = new ShowCar("BMV", 2022, false, 5);
//        System.out.println(showCar);
//
//
//
//        garage.addCar(car);
//        garage.addCar(performanceCar);
//        garage.addCar(showCar);
//
//        System.out.println(garage);

        Garage garage = new Garage();
        String inputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework09/data.txt";
        String outputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework09/output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] split = line.split("[|]");
                String mark = split[0].trim();
                int year = Integer.parseInt(split[1].trim());
                boolean race = Boolean.parseBoolean(split[2].trim());
                Car car = new Car(mark, year, race);
                garage.addCar(car);


            }
            List<Car> parkedCars = garage.getParkedCars();
            System.out.println(parkedCars);
            for (Car car : parkedCars) {
                bw.write(car.getMark() + " " + car.getYear() + " " + car.getRacing());
                bw.newLine();
            }



        }catch (IOException e) {
                    e.printStackTrace();
                }



    }
}
