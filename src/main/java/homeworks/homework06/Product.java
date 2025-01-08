package homeworks.homework06;

import java.util.Objects;

//Характеристики Продукта: название и стоимость. Название продукта не
//может быть пустой строкой, оно должно быть. Стоимость продукта не может
//быть отрицательным числом
public class Product {

    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.equals("")) {
            System.out.println("Наименование продукта - строка не может быть пустым");
        } else {
            this.productName = productName;
        }
    }

    public int getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice < 0) {
            System.out.println(" Стоимость продукта не может быть отрицательным числом");
        } else {
            this.productPrice = productPrice;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productPrice == product.productPrice && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }
}
