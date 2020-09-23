package duke.tasks;

/**
 * Represents a To Do Task in the list
 */
public class ToDo extends Task {

    /**
     * Creates a To Do task
     *
     * @param description describes the task
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns full details of To Do task
     *
     * @return string details of task
     */
    @Override
    public String toString() {
        return "\uD835\uDD4B " + super.toString();
    }
}
