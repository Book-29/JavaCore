package homeworks.homework07.product;

import java.util.Objects;

public class DiscountProduct extends Product {

    private int discount;
    private Boolean isDiscount;

    public DiscountProduct(String productName, int productPrice, int discount) {
        super(productName, productPrice);
        this.discount = discount;

    }

    public void setDiscount(Boolean discount) {
        isDiscount = discount;
    }

    public void setDiscount(int discount) {
        if (discount < 0 || discount == 0) {
            System.out.println(" цена неправильная");
        } else {

            this.discount = discount;

        }
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "productName=" + super.getProductName() +
                ", productPrice=" + super.getProductPrice()+
                "discount=" + discount +
                ", isDiscount=" + isDiscount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && Objects.equals(isDiscount, that.isDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, isDiscount);
    }
}
