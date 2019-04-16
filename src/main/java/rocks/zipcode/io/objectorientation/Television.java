package rocks.zipcode.io.objectorientation;

public class Television {

    private Integer channel;
    private Boolean isTurnedOn;

    public Television() {
        this.channel = 0;
        this.isTurnedOn = false;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void setChannel(Integer channel) {
        if(!isTurnedOn){
            throw new IllegalStateException();
        }
        this.channel = channel;
    }

    public TVChannel getChannel() {
        return TVChannel.getByOrdinal(channel);
    }
}
