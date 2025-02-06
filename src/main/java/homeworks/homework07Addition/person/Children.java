package homeworks.homework07Addition.person;



import java.util.Objects;

public class Children extends Person {


public Children(String name, double money, int age) {
   super(name, money, age);

    }


    @Override
    public String toString() {
        return "Children{" +
                "name='" + super.getName() +
                ", money=" + super.getMoney() +
                ", age=" + super.getAge() +
                '}';
    }
}
