package duke.tasks;

public class Task {
    protected String description;
    protected boolean isDone;
    protected boolean hasDate;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.hasDate = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Good job! I checked this off the list for you:");
        System.out.println(this);
    }


    public void delete(int newNumberOfTasks) {
        System.out.println("Okay, I've removed this task: ");
        System.out.println(this);
        System.out.print("Now you have " + newNumberOfTasks);
        if (newNumberOfTasks == 1) {
            System.out.println(" task in the list.");
        } else {
            System.out.println(" tasks in the list.");
        }
    }

    public void isDone() {
        this.isDone = true;
    }

    public String toString(){
        return getStatusIcon() + " " + description;
    }

    public void hasDate(){
        this.hasDate = true;
    }

    public boolean dateAvailable(){
        return hasDate;
    }



}


