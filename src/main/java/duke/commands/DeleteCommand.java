package duke.commands;

import duke.parser.FileHandler;
import duke.system.DukeException;
import duke.system.Messages;
import duke.system.State;
import duke.tasks.Task;

import java.io.IOException;
import java.util.ArrayList;

public class DeleteCommand extends Command {
    public DeleteCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public  void execute(){
        String[] words = input.split(" ");

        try {
            int delete = Integer.parseInt(words[1]);
            if (delete <= tasks.size()) {
                tasks.get(delete-1).delete(tasks.size()-1);
                tasks.remove(delete-1);
                FileHandler.writeToFile(tasks);
            } else {
                throw new DukeException();
            }
        } catch (DukeException e){
            Messages.printNotFound();
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Messages.printDeleteIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
