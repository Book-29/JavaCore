package homeworks.homework09.race;

import homeworks.homework09.car.Car;

import java.util.List;

public class CasualRace extends Race{

    public CasualRace() {
    }

    public CasualRace(int length, String route, int prize, List<Car> participants) {
        super(length, route, prize, participants);
    }

    @Override
    public String toString() {
        return "CasualRace{" +
                "length=" + super.getLength() +
                 ", route='" + super.getRoute() +
                ", prize=" + super.getPrize() +
                 ", participants=" + super.getParticipants() +
                '}';
    }
}
