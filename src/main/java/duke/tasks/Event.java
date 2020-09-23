package duke.tasks;




import java.time.LocalDate;

/**
 * Represents an Event Task in the task list
 */
public class Event extends Task {

    protected String at;

    /**
     * Creates an Event task
     *
     * @param description describes the task
     * @param at when the task is
     */

    public Event(String description, String at, LocalDate date) {
        super(description);
        this.at = at;
    }

    /**
     * Returns full details of deadline task
     *
     * @return string details of task
     */
    @Override
    public String toString() {
        return "\uD835\uDD3C " + super.toString() + " (at: " + at + ")";
    }

}
