package homeworks.homework07.Addition;

import homeworks.homework07.Addition.person.Person;
import homeworks.homework07.Addition.product.DiscountProduct;
import homeworks.homework07.Addition.product.Product;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        Scanner scannerPersonAge = new Scanner(System.in);
        System.out.println("Введите возраст: ");
        String strAgePerson = scannerPersonAge.nextLine();


        Pattern patternAge = Pattern.compile("(\\d+)");
        Matcher matcherAge = patternAge.matcher(strAgePerson);

        Person person   = null;

        while (matcherAge.find()) {

            int agePerson = matcherAge.group(1) != null ? Integer.parseInt(matcherAge.group(1)) : 0;

            person = new Person("Lara", 50, agePerson);

            person.setAge(agePerson);
        }



    }


}
