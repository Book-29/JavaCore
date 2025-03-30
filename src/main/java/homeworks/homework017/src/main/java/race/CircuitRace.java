package race;

//CircuitRace
//Класс имеет дополнительное поле laps (int).
//Оба новых класса имеют дополнительный параметр, помимо
//наследуемых у класса Race. Параметр вводится в качестве последнего
//параметра при открытии одного из этих типов гонок.

import car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Getter
@Setter

public class CircuitRace extends Race {
    private int laps;



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
