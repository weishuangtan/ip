public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "\uD835\uDD3C " + super.toString() + " (at: " + at + ")";
    }
}
