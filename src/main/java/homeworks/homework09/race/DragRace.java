package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class DragRace extends Race{

    public DragRace(int length, String route, int prize, List<Car> participants) {
        super(length, route, prize, participants);
    }

    public DragRace() {
    }

    @Override
    public String toString() {
        return "DragRace{" +
                "length=" + super.getLength() +
                ", route='" + super.getRoute() +
                 ", prize=" + super.getPrize() +
                ", participants=" + super.getParticipants() +
                '}';
    }
}
