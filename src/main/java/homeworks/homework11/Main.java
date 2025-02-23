package homeworks.homework11;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        String inputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework11/input.txt";
        String outputPath = "C:/Users/User/IdeaProjects/Innopolis/JavaCore/src/main/java/homeworks/homework11/output.txt";
        String colorToFind = "Black";
        int mileageToFind = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("[|]");

                if (split.length == 5) {
                    String number = split[0].trim();
                    String model = split[1].trim();
                    String color = split[2].trim();
                    int mileage = Integer.parseInt(split[3].trim());
                    int price = Integer.parseInt(split[4].trim());

                    Car car = new Car(number, model, color, mileage, price);
                    cars.add(car);
                    bw.write(number + " " + model + " " + color + " " + mileage + " " + price);
                    bw.newLine();
                }

            }
            List<String> numbers = cars.stream()
                    .filter(car -> car.getColor().equals(colorToFind) || car.getMileage() == mileageToFind)
                    .map(Car::getNumber)
                    .collect(Collectors.toList());
            String numbersString = String.join(", ", numbers);

            System.out.println("Номера автомобилей по цвету или пробегу: " + numbersString);



            Optional<Car> carMinPrice = cars.stream()
                    .min(Comparator.comparing(Car::getPrice));

            if (carMinPrice.isPresent()) {
                System.out.println("Цвет автомобиля с минимальной стоимостью: " + carMinPrice.get().getColor());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
