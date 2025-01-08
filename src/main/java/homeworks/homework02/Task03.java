package homeworks.homework02;

import java.util.Scanner;

public class Task03 {

    //Задача 3*. Напишите Java-программу для объединения данной строки с
    //самим собой заданное количество раз.
   public static void main(String[] args) {
       stringPrint();
   }
   private static void stringPrint() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Исходная строка: ");
       String line = scanner.nextLine();
       System.out.println("Сколько раз вывести строку? ");
       int number = scanner.nextInt();
       for (int i = 0; i < number; i++) {
           System.out.print(line);
       }

   }



}

