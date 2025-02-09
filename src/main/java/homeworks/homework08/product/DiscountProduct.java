package homeworks.homework08.product;

import java.util.Objects;

public class DiscountProduct extends Product {

    private double discount;
    private Boolean isDiscount;

    public DiscountProduct(String productName, double productPrice, double discount, Boolean isDiscount) {
        super(productName, productPrice);
        this.discount = discount;
        this.isDiscount = isDiscount;
    }

    public DiscountProduct(String productName, double productPrice, double discount) {
        super(productName, productPrice);
        this.discount = discount;
    }


    public void setDiscount(Boolean discount) {
        isDiscount = discount;
    }

   public void setDiscount(double discount) {
         if (discount < 0 || discount == 0) {
             System.out.println(" цена неправильная");
         } else {

             this.discount = discount;

         }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return Objects.equals(discount, that.discount) && Objects.equals(isDiscount, that.isDiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, isDiscount);
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
}
