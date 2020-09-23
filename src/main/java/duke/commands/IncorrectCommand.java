package duke.commands;

import duke.system.Ui;
import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

/**
 * Prints Ui to tell user that input is incorrect
  */
public class IncorrectCommand extends Command {
    public IncorrectCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute (){
        Ui.printInvalidInput();
    }
}
