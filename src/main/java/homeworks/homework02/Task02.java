package homeworks.homework02;

import java.util.Scanner;

public class Task02 {
    //    Задача 2. Напишите программу на Java, которая принимает два целых
//    числа от пользователя, а затем печатает сумму, разницу, произведение, среднее
//    значение, расстояние (разница между целыми числами), максимум (большее из
//    двух целых чисел), минимум (меньшее из двух целых чисел).
    public static void main(String[] args) {
        mathOperations();
    }

    private static void mathOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Введите второе число:");
        int secondNumber = scanner.nextInt();
        int sum = firstNumber + secondNumber;
        int difference = Math.abs(firstNumber - secondNumber);
        int product = firstNumber * secondNumber;
        int average = (firstNumber + secondNumber) / 2;
        int distance = Math.abs(firstNumber - secondNumber);
        int max = Math.max(firstNumber, secondNumber);
        int min = Math.min(firstNumber, secondNumber);
        System.out.println("Сумма двух целых чисел: " + sum);
        System.out.println("Разница двух целых чисел: " + difference);
        System.out.println("Произведение из двух целых чисел: " + product);
        System.out.println("Среднее из двух целых чисел: " + average);
        System.out.println("Расстояние двух целых чисел: " + distance);
        System.out.println("Максимальное целое число: " + max);
        System.out.println("Минимальное целое число: " + min);

    }
}
