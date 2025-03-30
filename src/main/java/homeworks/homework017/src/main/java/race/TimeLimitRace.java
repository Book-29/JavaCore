package race;

//TimeLimitRace
//Класс имеет дополнительное поле goldTime (int)

import car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
@Getter
@Setter

public class TimeLimitRace extends Race {
    private int goldTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimeLimitRace that = (TimeLimitRace) o;
        return goldTime == that.goldTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goldTime);
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participants=" + super.getParticipants() +
                ", goldTime=" + goldTime +
                '}';
    }
}
