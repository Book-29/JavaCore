package homeworks.homework05;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
            Television myTelevision = new Television();
            myTelevision.setModel("Sony");
            System.out.println(myTelevision.toString());

            Television myTelevision2 = new Television();
            myTelevision2.setModel("Sharp");
            System.out.println(myTelevision2.toString());

            Television myTelevision3 = new Television();
             myTelevision3.setModel("Xiaomi");
             System.out.println(myTelevision3.toString());

             Television myTelevision4 = new Television();
             myTelevision4.setModel("Samsung");
             System.out.println(myTelevision4.toString());

             Television myTelevision5 = new Television();
             myTelevision5.setModel("Hyundai");
             System.out.println(myTelevision5.toString());

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите модель TV: ");
        String tv = scan.nextLine();
        System.out.print(tv);




    }
}
