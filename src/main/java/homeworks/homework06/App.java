package homeworks.homework06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String inputText = sc.nextLine();

        Pattern pattern = Pattern.compile("([а-яА-Я]+)(?: ([а-яА-Я]+))? = (\\d+);");
        Matcher matcher = pattern.matcher(inputText);
        while (matcher.find()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            int money = Integer.parseInt(matcher.group(3));
            if (lastName == null) {
                System.out.println("First Name: " + firstName + ", Amount: " + money);
            } else {
                System.out.println("First Name: " + firstName + " " +  lastName + ", Amount: " + money);
            }

            Scanner scannerProduct = new Scanner(System.in);
            String inputTextProduct = scannerProduct.nextLine();
            Pattern patternProduct = Pattern.compile("([а-яА-Я]+) = (\\d+);");
            Matcher matcherProduct = patternProduct.matcher(inputTextProduct);
            while (matcherProduct.find()) {
                String nameProduct = matcherProduct.group(1);
                int amount = Integer.parseInt(matcherProduct.group(2));

                System.out.println("Name: " + nameProduct + ", Amount: " + amount);

                }


        }
    }
}





//        Scanner scan = new Scanner(System.in);
//        boolean check = true;
//        while (check) {
//            String input = scan.nextLine();
//
//            if (input.equals("END")) {
//                check = false;
//            }
//        }


