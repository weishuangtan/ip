package duke.commands;

import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

public abstract class Command {
    protected String input;
    protected ArrayList<Task> tasks;
    protected State state;

    public Command (String input, ArrayList<Task> tasks, State state) {
        this.input = input;
        this.tasks = tasks;
        this.state = state;
    }

    public void execute(){

    }
}
