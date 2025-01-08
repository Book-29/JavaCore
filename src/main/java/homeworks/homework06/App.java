package homeworks.homework06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя и количество денег: ");
        String inputText = sc.nextLine();

        Pattern pattern = Pattern.compile("([а-яА-Я]+)(?: ([а-яА-Я]+))? = (\\d+)?;?");
        Matcher matcher = pattern.matcher(inputText);


        while (matcher.find()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            String name = firstName + " " + lastName;
            int money = Integer.parseInt(matcher.group(3));
            Person person = new Person(name, money);

            if (lastName == null) {
                person.setName(firstName);

//                System.out.println("First Name: " + firstName + ", Amount: " + money); -проверка
            } else {
                person.setName(firstName + " " + lastName);

            }
            person.setMoney(money);

            // System.out.println("First Name: " + firstName + " " +  lastName + ", Amount: " + money); проверка
            Scanner scannerProduct = new Scanner(System.in);
            System.out.println("Введите наименование товара и стоимость товара: ");
            String inputTextProduct = scannerProduct.nextLine();
            Pattern patternProduct = Pattern.compile("([а-яА-Я]+)(?: ([а-яА-Я]+))? = (\\d+)?;?");
            Matcher matcherProduct = patternProduct.matcher(inputTextProduct);
            while (matcherProduct.find()) {
                String firstWord = matcherProduct.group(1);
                String lastWord = matcherProduct.group(2);
           String productName = firstWord + " " + lastWord;
                int productPrice = Integer.parseInt(matcherProduct.group(3));

                Product product = new Product(productName, productPrice);
                if (lastWord == null) {

                    product.setProductName(firstWord );
              } else {

                    product.setProductName(firstWord + " " + lastWord);
                }

                product.setProductPrice(productPrice);
                if (person.getMoney() < product.getProductPrice()) {
                    System.out.println(person.getName() + " -  Ничего не куплено  " + product.getProductName());

                } else if (productName.equals("Торт")) {
                    System.out.println(person.getName() + " не может позволить себе " + product.getProductName());
                } else {

                    System.out.println(person.getName() + " купил " + product.getProductName());
                }

//                System.out.println("Name: " + nameProduct + ", Amount: " + amount); проверка

           }

        }
    }
}





