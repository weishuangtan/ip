package duke.tasks;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "\uD835\uDD3B " + super.toString() + " (by: " + by + ")";
    }
}
