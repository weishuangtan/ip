package duke.commands;

import duke.system.Storage;
import duke.system.Ui;
import duke.system.State;
import duke.tasks.Event;
import duke.tasks.Task;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            LocalDate date = findDate();
            String task = input.substring(6);
            String[] descriptionAndAt = task.split(" /at ");
            Event item = new Event(descriptionAndAt[0], descriptionAndAt[1], date);
            tasks.add(item);
            Ui.printAdded(item,tasks.size());
            Storage.writeToFile(tasks);
        } catch (IndexOutOfBoundsException e) {
            Ui.printEventIncorrectFormat();
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


