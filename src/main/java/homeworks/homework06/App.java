package homeworks.homework06;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст : ");
        String inputText = sc.nextLine();

        Pattern pattern = Pattern.compile("([а-яА-Я]+)(?: ([а-яА-Я]+))?(?: = (-?\\d+))?;?|(END)");
        Matcher matcher = pattern.matcher(inputText);
        Person person = null;
        while (matcher.find()) {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            String name = firstName + (lastName != null ? " " + lastName : "");

            String moneyStr = matcher.group(3);
            String end = matcher.group(4);
            int money = moneyStr != null ? Integer.parseInt(moneyStr) : 0;
            person = new Person(name, 0);
            person.setMoney(money);


        }


        Scanner scannerProduct = new Scanner(System.in);
        System.out.println("Введите наименование товара и стоимость товара: ");
        String inputTextProduct = scannerProduct.nextLine();

        Pattern patternProduct = Pattern.compile("([а-яА-Я]+)(?: ([а-яА-Я]+))?(?: = (-?\\d+))?;?");
        Matcher matcherProduct = patternProduct.matcher(inputTextProduct);

        Product lastProduct = null;
        while (matcherProduct.find()) {


            String firstWord = matcherProduct.group(1);
            String lastWord = matcherProduct.group(2);
            String nameProduct = firstWord + (lastWord != null ? " " + lastWord : "");
            int productPrice = matcherProduct.group(3) != null ? Integer.parseInt(matcherProduct.group(3)) : 0;

            lastProduct = new Product(nameProduct, 0);
            lastProduct.setProductPrice(productPrice);


        }


        if (lastProduct != null && person != null) {

            if (person.getMoney() < lastProduct.getProductPrice()) {
                System.out.println(person.getName() + " -  не может позволить купить " + lastProduct.getProductName());

            } else

                System.out.println(person.getName() + " купил " + lastProduct.getProductName());
                }
            }
        }













