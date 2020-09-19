package duke.commands;

import duke.parser.FileHandler;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Deadline;
import duke.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;

public class DeadlineCommand extends Command{


    public DeadlineCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute() {
        try {
            String task = input.substring(9);
            String[] descriptionAndBy = task.split(" /by ");

            Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1]);
            tasks.add(item);
            Messages.printAdded(item,tasks.size());
            FileHandler.writeToFile(tasks);
        }  catch (IndexOutOfBoundsException e ) {
            Messages.printDeadlineIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
