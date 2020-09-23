package duke.commands;

import duke.system.Storage;
import duke.system.DukeException;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Task;
import duke.tasks.ToDo;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Adds a To Do type task into the list
 */
public class ToDoCommand extends Command{
    public ToDoCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }


    public void execute() {
        try {
            String[] words = input.split(" ");
            if (words.length > 1) {
                String task = input.substring(5);
                ToDo item = new ToDo(task);
                tasks.add(item);
                Ui.printAdded(item, tasks.size());
                Storage.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e) {
            Ui.printToDoIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
