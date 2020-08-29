public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "\uD835\uDD4B " + super.toString();
    }
}