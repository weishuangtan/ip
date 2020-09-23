package duke.commands;

import duke.system.Ui;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

/**
 * Exits the chat bot
 */
public class ExitCommand extends Command {
    public ExitCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    /**
     * Changes the running state of chat bot
     */
    public void execute () {
        Ui.printGoodbye();
        state.exit();
    }
}
