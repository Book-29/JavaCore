package homeworks.homework07.Addition.person;

import homeworks.homework07.product.Product;

import java.util.Arrays;
import java.util.Objects;



public class Person {

    private String name;
    private double money;
    private int age;
    private double credit;
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

    public Person(String name, double money, int age) {
        this.name = name;
        this.money = money;
        this.age = age;


    }
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        if (credit < 0) {
            System.out.println("Кредит не может быть отрицательным");
        } else {
            this.credit = credit;
        }
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
    }
   public Product[] getBasket() {
    return basket;
   }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Возраст не может быть отрицательным");
        } else if (age >= 1 && age <= 6) {
                System.out.println(" Дети младше 6 лет не могут купить товары");
        } else if (age >= 18 && age <= 65) {
                System.out.println("Можно товары  покупать в кредит");

        } else {
            this.age = age;

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && age == person.age && credit == person.credit && index == person.index && Objects.equals(name, person.name) && Objects.deepEquals(basket, person.basket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, age, credit, Arrays.hashCode(basket), index);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", age=" + age +
                ", credit=" + credit +
                ", basket=" + Arrays.toString(basket) +
                ", index=" + index +
                '}';
    }

}
