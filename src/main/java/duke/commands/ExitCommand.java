package duke.commands;

import duke.system.Messages;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

public class ExitCommand extends Command {
    public ExitCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute (){
        Messages.printGoodbye();
        state.exit();
    }
}
