package homeworks.homework06.additional;

import java.util.Arrays;
import java.util.Objects;

public class Channel {
    private String name;
    private int channelNumber;
    private Program[] programs = new Program[10];

    public Channel(String name, int channelNumber, Program[] programs) {
        this.name = name;
        this.channelNumber = channelNumber;
        this.programs = programs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", channelNumber=" + channelNumber +
                ", programs=" + Arrays.toString(programs) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return channelNumber == channel.channelNumber && Objects.equals(name, channel.name) && Objects.deepEquals(programs, channel.programs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, channelNumber, Arrays.hashCode(programs));
    }
}
