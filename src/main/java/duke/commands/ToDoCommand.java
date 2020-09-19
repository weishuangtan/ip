package duke.commands;

import duke.parser.FileHandler;
import duke.system.DukeException;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.io.IOException;
import java.util.ArrayList;

public class ToDoCommand extends Command{
    public ToDoCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    /**
     * Adds To Do task into the list of tasks
     */
    public void execute() {
        try {
            String[] words = input.split(" ");
            if (words.length > 1) {
                String task = input.substring(5);
                ToDo item = new ToDo(task);
                tasks.add(item);
                Messages.printAdded(item, tasks.size());
                FileHandler.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Messages.printToDoIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
