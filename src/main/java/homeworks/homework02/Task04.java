package homeworks.homework02;

import java.util.Scanner;

public class Task04 {

    //Задача 4*. Напишите программу на Java для печати сетки из заданных
    //элементов.


    public static void main(String[] args) {
printArray();

    }
    private static void printArray() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число строк и столбцов сети: ");
            int rows = scanner.nextInt();
            System.out.println("Введите повторяемый элемент сетки: ");
            String element = scanner.next();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(element);
                }
                System.out.println();
            }


    }
}
