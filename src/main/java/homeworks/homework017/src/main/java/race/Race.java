package race;

import car.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

//Гонка имеет следующие свойства: длина (int), маршрут (строка),
//призовой фонд (int) и участники (коллекция автомобилей),


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Race {
    private int length;
    private String route;
    private int prize;
    private List<Car> participants;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length && prize == race.prize && Objects.equals(route, race.route) && Objects.equals(participants, race.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prize, participants);
    }

    @Override
    public String toString() {
        return "Race{" +
                "length=" + length +
                ", route='" + route + '\'' +
                ", prize=" + prize +
                ", participants=" + participants +
                '}';
    }
}
