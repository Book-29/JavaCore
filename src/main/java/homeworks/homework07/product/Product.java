package homeworks.homework07.product;

import java.util.Objects;

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
        if (productName == null || productName.equals("") || productName.matches("\\d+") || productName.length() < 3) {
            System.out.println("Недопустимое имя продукта!");
        } else {
            this.productName = productName;
        }
    }
    public int getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice < 0 || productPrice == 0) {
            System.out.println(" Недопустимая стоимость продукта!");
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
