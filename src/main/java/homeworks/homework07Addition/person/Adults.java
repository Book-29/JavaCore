package homeworks.homework07Addition.person;

public class Adults extends Person {




    public Adults(String name, double money, int age) {
        super(name, money, age);





    }


    @Override
    public String toString() {
        return "Adults{" +
                "name='" + super.getName() +
                 ", money=" + super.getMoney() +
                ", age=" + super.getAge() +
                '}';
    }

}
