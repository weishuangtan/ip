package duke.commands;

import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

/**
 * Represents an executable command
 */
public abstract class Command {
    protected String input;
    protected ArrayList<Task> tasks;
    protected State state;

    /**
     * Constructor for Command class
     *
     * @param input user's input
     * @param tasks list of tasks
     * @param state running state of chat bot
     */
    public Command (String input, ArrayList<Task> tasks, State state) {
        this.input = input;
        this.tasks = tasks;
        this.state = state;
    }

    public void execute() {
    }
}
