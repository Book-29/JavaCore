package homeworks.homework03;
//Формулировка задания:
//Реализовать класс Телевизор. У класса есть поля, свойства и методы.
//Проверить работу в классе App, методе main.
//Обратить внимание на переопределение метода toString.

public class Television {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;
    private Integer length;

    public Television(String brand, String model, int year, String color, int price, Integer length) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.length = length;

    }
    public Television() {}
    public void setBrand(String brand) {
        this.brand = brand;

    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Television{" +
                "model='" + model + '\'' +
                '}';
    }




}

