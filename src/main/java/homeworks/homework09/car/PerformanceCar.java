package homeworks.homework09.car;
//PerformanceCar – гоночный автомобиль.
//        Имеет дополнения addOns (массив строк, по умолчанию – пустой)
//        Увеличенная мощность двигателя на 50%.
//        Уменьшенная подвеска на 25%.

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;


    public PerformanceCar(String[] addOns) {
        this.addOns = addOns;
    }

    public PerformanceCar(String mark, String model, int year, int power, int acceleration, int suspension, int durability, boolean racing) {
        super(mark, model, year, (int) (power*1.5), acceleration, (int) (suspension*0.75), durability, racing);
    }
    public PerformanceCar(String mark, int year, boolean racing) {
        super(mark, year, racing);
        this.addOns = addOns;
    }


    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "mark='" + super.getMark() +
                ", year=" + super.getYear() +
                ", power=" + super.getPower() +
                ", acceleration=" + super.getAcceleration() +
                ", suspension=" + super.getSuspension() +
                ", durability=" + super.getDurability() +
                ", racing=" + super.isRacing() +
                ", addOns=" + Arrays.toString(addOns) +
                '}';
    }
}
