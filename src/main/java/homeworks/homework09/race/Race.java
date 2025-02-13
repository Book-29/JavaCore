package homeworks.homework09.race;
import homeworks.homework09.car.Car;

import java.util.List;
import java.util.Objects;

//Гонка имеет следующие свойства: длина (int), маршрут (строка),
//призовой фонд (int) и участники (коллекция автомобилей),
public class Race {
    private int length;
    private String route;
    private int prize;
    private List<Car> participants;

    public Race(int length, String route, int prize, List<Car> participants) {
        this.length = length;
        this.route = route;
        this.prize = prize;
        this.participants = participants;
    }

    public Race() {
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public List<Car> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Car> participants) {
        this.participants = participants;
    }

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
