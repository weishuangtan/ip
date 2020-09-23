package duke.tasks;

/**
 * Represents a Deadline Task in the task list
 */
public class Deadline extends Task {

    protected String by;

    /**
     * Creates a Deadline task
     *
     * @param description describes the task
     * @param by deadline of task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns full details of deadline task
     *
     * @return string details of task
     */
    @Override
    public String toString() {
        return "\uD835\uDD3B " + super.toString() + " (by: " + by + ")";
    }
}
