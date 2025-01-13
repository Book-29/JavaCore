package homeworks.homework06.additional;

import java.util.Objects;

public class Program {
    private String name;
    private int spectators;
    private int rating;

    public Program(String name, int spectators, int rating) {
        this.name = name;
        this.spectators = spectators;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpectators() {
        return spectators;
    }

    public void setSpectators(int spectators) {
        this.spectators = spectators;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Program{" +
                "name='" + name + '\'' +
                ", spectators=" + spectators +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Program program = (Program) o;
        return spectators == program.spectators && rating == program.rating && Objects.equals(name, program.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spectators, rating);
    }
}

