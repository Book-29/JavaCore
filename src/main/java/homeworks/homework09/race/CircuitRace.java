package homeworks.homework09.race;

//CircuitRace
//Класс имеет дополнительное поле laps (int).
//Оба новых класса имеют дополнительный параметр, помимо
//наследуемых у класса Race. Параметр вводится в качестве последнего
//параметра при открытии одного из этих типов гонок.

import homeworks.homework09.car.Car;

import java.util.List;
import java.util.Objects;

public class CircuitRace extends Race {
    private int laps;

    public CircuitRace(int length, String route, int prize, List<Car> participants, int laps) {
        super(length, route, prize, participants);
        this.laps = laps;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CircuitRace that = (CircuitRace) o;
        return laps == that.laps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), laps);
    }

    @Override
    public String toString() {
        return "CircuitRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participants=" + super.getParticipants() +
                "laps=" + laps +
                '}';
    }
}
