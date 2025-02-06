package homeworks.homework07Addition.person;

import java.util.Objects;

public class Pensioner extends Person {
private double discountPensioner = 5;
    public Pensioner(String name, double money, int age) {
        super(name, money, age);

    }


    public double getDiscountPensioner() {
        return discountPensioner;
    }

    public void setDiscountPensioner(double discountPensioner) {
        this.discountPensioner = discountPensioner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pensioner pensioner = (Pensioner) o;
        return Double.compare(discountPensioner, pensioner.discountPensioner) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountPensioner);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "name='" + super.getName() +
                ", money=" + super.getMoney() +
                ", age=" + super.getAge() +
                "discountPensioner=" + discountPensioner +
                '}';
    }
}
