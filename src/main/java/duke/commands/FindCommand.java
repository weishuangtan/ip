package duke.commands;

import duke.system.State;
import duke.system.Ui;
import duke.tasks.Task;

import java.util.ArrayList;

public class FindCommand extends Command {
    public FindCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute () {
        try {
            String keyword = input.substring(5);
            boolean hasMatchTask = false;
            if (tasks.size() == 0) {
                System.out.println("Unable to find a task with the keyword given");
            } else {
                int i = 0;
                for (Task task : tasks) {
                    if (task.toString().contains(keyword)) {
                        System.out.println("(" + (i + 1) + ") " + task);
                        i++;
                        hasMatchTask = true;
                    }
                }
                if(!hasMatchTask) {
                    System.out.println("Unable to find a task with the keyword given");
                }
            }
            System.out.println("Feel free to continue adding to the list! :)");
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Ui.printFindIncorrectFormat();
        }
    }
}
