package homeworks.homework08.product;

import java.util.Objects;


public class Product {

    private String productName;
    private double productPrice;
    private Boolean kidAge;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
    public void addSale(int value) {
        this.productPrice -= value;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.equals("") || productName.matches("\\d+") || productName.length() > 3) {
            System.out.println("Недопустимое имя продукта!");
        } else {
            this.productName = productName;
        }
    }
    public Boolean getKidAge() {
        return kidAge;
    }

    public void setKidAge(Boolean kidAge) {
        this.kidAge = kidAge;
    }
    public double getProductPrice() {

        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        if (productPrice < 0 || productPrice == 0) {
            System.out.println(" цена неправильная");
        } else {
            this.productPrice = productPrice;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", kidAge=" + kidAge +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productPrice == product.productPrice && Objects.equals(productName, product.productName) && Objects.equals(kidAge, product.kidAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice, kidAge);
    }

}
