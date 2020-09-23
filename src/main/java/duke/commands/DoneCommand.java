package duke.commands;

import duke.system.Storage;
import duke.system.DukeException;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;

public class DoneCommand extends Command{
    public DoneCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    /**
     * Tries checking given task off the list
     */
    public  void execute() {
        String[] words = input.split(" ");

        try {
            int complete = Integer.parseInt(words[1]);
            if (complete <= tasks.size()) {
                tasks.get(complete - 1).markAsDone();
                Storage.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Ui.printNotFound();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Ui.printDoneIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
