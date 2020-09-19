package duke.commands;

import duke.parser.FileHandler;
import duke.system.DukeException;
import duke.system.Messages;
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
                FileHandler.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Messages.printNotFound();
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            Messages.printDoneIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
