package duke.tasks;

import java.time.LocalDate;

public class Deadline extends Task {

    protected String by;
    protected LocalDate date;

    public Deadline(String description, String by, LocalDate date) {
        super(description);
        this.by = by;
        this.date = date;
    }

    @Override
    public String toString() {
        return "\uD835\uDD3B " + super.toString() + " (by: " + by + ")";
    }
}
