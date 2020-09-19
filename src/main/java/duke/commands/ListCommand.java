package duke.commands;

import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    /**
     * Prints the current collated list based on user inputs
     */
    public void execute () {
        if (tasks.size() == 0) {
            System.out.println("Looks like you have no task yet!");
        } else {
            System.out.println("Here is the collated list of your tasks:");
            int i = 0;
            for (Task task : tasks) {
                System.out.println("(" + (i + 1) + ") " + task);
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }
}
