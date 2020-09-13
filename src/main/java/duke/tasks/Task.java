package duke.tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Good job! I checked this off the list for you:");
        System.out.println(this);
    }

    public void isDone() {
        this.isDone = true;
    }

    public String toString(){
        return getStatusIcon() + " " + description;
    }

}
