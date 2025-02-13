package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class DriftRace extends Race{


    public DriftRace(int length, String route, int prize, List<Car> participants) {
        super(length, route, prize, participants);
    }

    public DriftRace() {
    }

    @Override
    public String toString() {
        return "DriftRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute() +
                ", prize=" + super.getPrize() +
                ", participants=" + super.getParticipants() +
                '}';
    }
}
