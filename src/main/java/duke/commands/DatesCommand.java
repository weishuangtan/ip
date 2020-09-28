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

        if (tasks.size() == 0) {
            System.out.println("Looks like you have no tasks with dates yet!");
        } else {
            System.out.println("Here is the collated list of your tasks with dates:");
            int i = 0;
            for (Task task : tasks) {
                if (task.dateAvailable()) {
                    System.out.println("(" + (i + 1) + ") " + task);
                }
                i++;
            }
        }
        System.out.println("Feel free to continue adding to the list! :)");
    }
}

