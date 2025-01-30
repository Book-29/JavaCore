package homeworks.homework06;

import java.util.Arrays;
import java.util.Objects;

//Характеристики Покупателя: имя, сумма денег и пакет с продуктами
//        (массив объектов типа Продукт). Имя не может быть пустой строкой. Деньги не
//могут быть отрицательным числом.
//Если Покупатель может позволить себе Продукт, то Продукт добавляется
//в пакет. Если у Покупателя недостаточно денег, то добавление не происходит.


public class Person {

    private String name;
    private int money;
    private  Product[] basket = new Product[10];

    private int index = 0;
    public void addProductBasket(Product product) {
    if (this.money > product.getProductPrice()) {
        this.basket[index] = product;
        index++;


    } else {
        System.out.println(name + " не может позволить себе " + product);
    }
}

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.basket = new Product[0];

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустой строкой ");
        } else {
            this.name = name;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
    }
   public Product[] getBasket() {
    return basket;
   }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && index == person.index && Objects.equals(name, person.name) && Objects.deepEquals(basket, person.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(basket), index);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", basket=" + Arrays.toString(basket) +
                ", index=" + index +
                '}';
    }
}
