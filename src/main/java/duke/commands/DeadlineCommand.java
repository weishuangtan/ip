package duke.commands;

import duke.system.Storage;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Deadline;
import duke.tasks.Task;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class DeadlineCommand extends Command{


    public DeadlineCommand(String input, ArrayList<Task> tasks, State state) {
        super(input, tasks, state);
    }

    public void execute() {
        try {
            LocalDate date = findDate();
            String task = input.substring(9);
            String[] descriptionAndBy = task.split(" /by ");
            Deadline item = new Deadline(descriptionAndBy[0], descriptionAndBy[1], date);
            tasks.add(item);
            Ui.printAdded(item,tasks.size());
            Storage.writeToFile(tasks);
        }  catch (IndexOutOfBoundsException e ) {
            Ui.printDeadlineIncorrectFormat();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public LocalDate findDate() {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            try {
                LocalDate date = LocalDate.parse(words[i], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                words[i] = date.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
                input = "";
                for (String word : words) {
                    input = input.concat(word + " ");
                }
                input = input.substring(0,input.length()-1);
                return date;
            } catch (DateTimeParseException ignored) {
            }
        }
        return null;
    }
}
