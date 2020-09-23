package duke.commands;

import duke.system.Storage;
import duke.system.DukeException;
import duke.system.Ui;
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
                Ui.printAdded(item, tasks.size());
                Storage.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Ui.printToDoIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
