package duke.commands;

import duke.system.State;
import duke.tasks.Task;

import java.util.ArrayList;

/**
 * Lists tasks that has date attached to it
 */
public class DatesCommand extends Command {

    public DatesCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute() {
        boolean hasDates = false;

        int i = 0;
        int j = 0;
        for (Task task : tasks) {
            if (task.dateAvailable()) {
                hasDates = true;
                if (j == 0) {
                    System.out.println("Here is the collated list of your tasks with dates:");
                }
                System.out.println("(" + (i + 1) + ") " + task);
                j++;
            }
            i++;
        }

        if (!hasDates) {
            System.out.println("Looks like you have no tasks with dates yet!");
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }
}

