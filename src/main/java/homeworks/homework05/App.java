package homeworks.homework05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите громкость звука: ");
        int maxVolume = scanner.nextInt();
        Television myTelevision = new Television();
            myTelevision.setModel("Sony");
            myTelevision.setChannel(new Random().nextInt(10));
            myTelevision.setVolume(50);
            myTelevision.setModeOn(true);

            if (myTelevision.getVolume() > maxVolume && myTelevision.getModeOn()) {
                System.out.println(myTelevision.toString());
            }

            Television myTelevision2 = new Television();
            myTelevision2.setModel("Sharp");
            myTelevision2.setChannel(new Random().nextInt(11));
            myTelevision2.setVolume(60);
            myTelevision2.setModeOn(false);
            if (myTelevision2.getVolume() > maxVolume  && myTelevision2.getModeOn()) {
                System.out.println(myTelevision2.toString());
            }

            Television myTelevision3 = new Television();
             myTelevision3.setModel("Xiaomi");
             myTelevision3.setChannel(new Random().nextInt(8));
            myTelevision3.setVolume(70);
            myTelevision3.setModeOn(false);
            if (myTelevision3.getVolume() > maxVolume && myTelevision3.getModeOn()) {
                System.out.println(myTelevision3.toString());
            }

             Television myTelevision4 = new Television();
             myTelevision4.setModel("Samsung");
             myTelevision4.setChannel(new Random().nextInt(1));
             myTelevision4.setVolume(80);
             myTelevision4.setModeOn(false);
             if (myTelevision4.getVolume() > maxVolume && myTelevision4.getModeOn()) {
                 System.out.println(myTelevision4.toString());
             }

             Television myTelevision5 = new Television();
             myTelevision5.setModel("Hyundai");
             myTelevision5.setChannel(new Random().nextInt(5));
             myTelevision5.setVolume(90);
             myTelevision5.setModeOn(true);
             if (myTelevision5.getVolume() > maxVolume && myTelevision5.getModeOn()) {
                 System.out.println(myTelevision5.toString());
             }

        Television myTelevision6 = new Television();
        myTelevision6.setModel("Sony");
        myTelevision6.setChannel(new Random().nextInt(10));
        myTelevision6.setVolume(100);
        myTelevision6.setModeOn(true);
        if (myTelevision6.getVolume() > maxVolume && myTelevision6.getModeOn()) {
            System.out.println(myTelevision6.toString());
        }


        Television myTelevision7 = new Television();
        myTelevision7.setModel("Sharp");
        myTelevision7.setChannel(new Random().nextInt(11));
        myTelevision7.setVolume(10);
        myTelevision7.setModeOn(false);
        if (myTelevision7.getVolume() > maxVolume && myTelevision7.getModeOn()) {
            System.out.println(myTelevision7.toString());
        }

        Television myTelevision8 = new Television();
        myTelevision8.setModel("Xiaomi");
        myTelevision8.setChannel(new Random().nextInt(8));
        myTelevision8.setVolume(20);
        myTelevision8.setModeOn(false);
        if (myTelevision8.getVolume() > maxVolume && myTelevision8.getModeOn()) {
            System.out.println(myTelevision8.toString());
        }

        Television myTelevision9 = new Television();
        myTelevision9.setModel("Samsung");
        myTelevision9.setChannel(new Random().nextInt(6));
        myTelevision9.setVolume(30);
        myTelevision9.setModeOn(true);
        if (myTelevision9.getVolume() > maxVolume && myTelevision9.getModeOn()) {
            System.out.println(myTelevision9.toString());
        }

        Television myTelevision10 = new Television();
        myTelevision10.setModel("Hyundai");
        myTelevision10.setChannel(new Random().nextInt(5));
        myTelevision10.setVolume(60);
        myTelevision10.setModeOn(true);
        if (myTelevision10.getVolume() > maxVolume && myTelevision10.getModeOn()) {
            System.out.println(myTelevision10.toString());
        }

//        Television[] televisions = new Television[10];
//        televisions[0] = myTelevision;
//        televisions[1] = myTelevision2;
//        televisions[2] = myTelevision3;
//        televisions[3] = myTelevision4;
//        televisions[4] = myTelevision5;
//        televisions[5] = myTelevision6;
//        televisions[6] = myTelevision7;
//        televisions[7] = myTelevision8;
//        televisions[8] = myTelevision9;
//        televisions[9] = myTelevision10;




//        Scanner scan = new Scanner(System.in);
//        System.out.println("Введите модель TV: ");
//        String tv = scan.nextLine();
//        System.out.print(tv);




    }
}
