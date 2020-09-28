package duke.tasks;



import java.time.LocalDate;

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
    public Deadline(String description, String by, LocalDate date) {
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
        return "\u24b9 " + super.toString() + " (by: " + by + ")";
    }

}
