package duke.commands;

import duke.system.Storage;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Event;
import duke.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;

public class EventCommand extends Command {
    public EventCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    /**
     * Adds Tasks.Event task into the list of tasks
     */
    public void execute() {
        try {
            String task = input.substring(6);
            String[] descriptionAndAt = task.split(" /at ");
            Event item = new Event(descriptionAndAt[0], descriptionAndAt[1]);
            tasks.add(item);
            Ui.printAdded(item,tasks.size());
            Storage.writeToFile(tasks);
        } catch (IndexOutOfBoundsException e) {
            Ui.printEventIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
