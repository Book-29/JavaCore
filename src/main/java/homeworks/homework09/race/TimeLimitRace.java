package homeworks.homework09.race;

//TimeLimitRace
//Класс имеет дополнительное поле goldTime (int)

import homeworks.homework09.car.Car;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prize, List<Car> participants, int goldTime) {
        super(length, route, prize, participants);
        this.goldTime = goldTime;

    }

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

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
