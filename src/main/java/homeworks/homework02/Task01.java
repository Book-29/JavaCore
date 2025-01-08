package homeworks.homework02;

import java.util.Scanner;

public class Task01 {
   //Задача 1. Напишите Java-программу для преобразования температуры из
    //Фаренгейта в градусы Цельсия.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите температуру в градусах Фаренгейта");
        double farenheit = scanner.nextDouble();
        double celsius = (farenheit - 32) * 5 / 9;

        System.out.println(farenheit + " градусов Фаренгейта равна " + celsius + " градусов Цельсия");
    }

}
