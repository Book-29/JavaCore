package homeworks.homework07;

import homeworks.homework07.product.DiscountProduct;
import homeworks.homework07.product.Product;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {

        Scanner scannerProduct = new Scanner(System.in);
        System.out.println("Введите наименование товара и стоимость товара: ");
        String inputTextProduct = scannerProduct.nextLine();

        Pattern patternProduct = Pattern.compile("([а-яА-Я\\d]+)(?: ([а-яА-Я]+))? = (\\d+)(?:, (\\d+))?");
        Matcher matcherProduct = patternProduct.matcher(inputTextProduct);

        Product lastProduct = null;
        DiscountProduct discountProduct = null;
        Product productName = null;
        while (matcherProduct.find()) {

            String firstWord = matcherProduct.group(1);
            String lastWord = matcherProduct.group(2);
            String nameProduct = firstWord + (lastWord != null ? " " + lastWord : "");
            productName = new Product(nameProduct, 0);
            productName.setProductName(nameProduct);

            int productPrice = matcherProduct.group(3) != null ? Integer.parseInt(matcherProduct.group(3)) : 0;
            int discount = matcherProduct.group(4) != null ? Integer.parseInt(matcherProduct.group(4)) : 0;

            lastProduct = new Product(nameProduct, productPrice);

            discountProduct = new DiscountProduct(nameProduct, productPrice, discount);
            if (productPrice > 0) {
                if (nameProduct != null && nameProduct.length() >= 3 && !nameProduct.matches("\\d+") && !nameProduct.equals(""))
                {
                    if (discount == 0){
                        System.out.println(" Обычные продукты: " + lastProduct.getProductName());

                    } else {
                        System.out.println(" Акционные продукты: " + discountProduct.getProductName()); }
                    }

                 } else {
            productName.setProductPrice(productPrice);
            }

        }


    }
}


